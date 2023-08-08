package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCompraDTO {
    private String codigoBarras;
    private Integer cantidad;
}
