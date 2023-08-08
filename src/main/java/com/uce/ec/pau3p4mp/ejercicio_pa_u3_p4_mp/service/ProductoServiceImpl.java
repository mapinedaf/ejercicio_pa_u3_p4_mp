package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.IProductoRepository;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.Producto;

@Service

public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoRepository productoRepository;

    @Override
    public void ingresarProducto(Producto producto) {
        try {

            Producto base = productoRepository.leer(producto.getCodigoBarras());

            base.setStock(base.getStock() + producto.getStock());

            productoRepository.actualizar(base);


        } catch (RuntimeException exception) {

            productoRepository.crear(producto);
        }


    }

}
