package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.service;

import java.util.List;


import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.dto.ProductoCompraDTO;

public interface IFacturaService {
    

    public  void  realizarFactura(List<ProductoCompraDTO> productos, String cedulaCliente);
}
