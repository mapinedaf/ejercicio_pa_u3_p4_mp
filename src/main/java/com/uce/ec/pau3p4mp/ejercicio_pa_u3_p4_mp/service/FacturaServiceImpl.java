package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.IFacturaRepository;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.IProductoRepository;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.DetalleFactura;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.Factura;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.Producto;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.dto.ProductoCompraDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    IProductoRepository productoRepository;

    @Autowired
    IFacturaRepository facturaRepository;

    @Override

    @Transactional(value =  TxType.REQUIRED)
    public void realizarFactura(List<ProductoCompraDTO> productosDTO, String cedulaCliente) {

        List<Producto> productos = productosDTO.stream().map(dto -> productoRepository.leer(dto.getCodigoBarras()))
                .toList();

        List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

        BigDecimal total = BigDecimal.valueOf(0);

        for (int i = 0; i < productos.size(); i++) {

            Producto productoActual = productos.get(i);

            ProductoCompraDTO dtoActual = productosDTO.get(i);

            int cantidad = dtoActual.getCantidad();

            if (productoActual.getStock() == 0)
                throw new RuntimeException();
            else if (productoActual.getStock() < cantidad) {
                cantidad = productoActual.getStock();
                productoActual.setStock(0);
            } else {
                productoActual.setStock(productoActual.getStock() - cantidad);
            }

            BigDecimal subtotal = productoActual.getPrecio().multiply(BigDecimal.valueOf(cantidad));

            DetalleFactura detalleFactura = DetalleFactura.builder()
                    .Cantidad(cantidad)
                    .precioUnitario(productoActual.getPrecio())
                    .subtiotal(subtotal)
                    .build();

            detalles.add(detalleFactura);

            productoRepository.actualizar(productoActual);

            total.add(subtotal);
        }
        
        Factura factura =Factura.builder().fecha(LocalDateTime.now())
        .cedulaCliente(cedulaCliente)
        .totalFactura(total)
        .detalles(detalles)
        .build();


        facturaRepository.crear(factura);
    }

}
