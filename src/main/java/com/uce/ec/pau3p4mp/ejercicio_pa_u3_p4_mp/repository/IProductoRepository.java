package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository;

import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.Producto;

public interface IProductoRepository {
    
    public void crear(Producto producto);

    public void actualizar(Producto producto);

    public Producto leer(String codigoBarras);


}
