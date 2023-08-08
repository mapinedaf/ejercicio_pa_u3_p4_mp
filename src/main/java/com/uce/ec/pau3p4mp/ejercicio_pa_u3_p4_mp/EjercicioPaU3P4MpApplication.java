package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.Producto;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.dto.ProductoCompraDTO;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.service.IFacturaService;
import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.service.IProductoService;

@SpringBootApplication
public class EjercicioPaU3P4MpApplication implements CommandLineRunner {

	@Autowired
	IProductoService productoService;

	@Autowired
	IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4MpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto producto = Producto.builder()
				.codigoBarras("001")
				.nombre("Listerine")
				.categoria("higiene personal")
				.stock(12)
				.precio(BigDecimal.valueOf(5))
				.build();
		productoService.ingresarProducto(producto);



		ProductoCompraDTO dto = new ProductoCompraDTO("001",5);

		List <ProductoCompraDTO> dtos = new ArrayList<>();

		dtos.add( dto);

		facturaService.realizarFactura(dtos,"485685982");
	}

}
