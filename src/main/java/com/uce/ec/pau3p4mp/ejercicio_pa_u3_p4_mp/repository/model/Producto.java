package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name="prod_id")
    @GeneratedValue(generator = "sec_producto", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_producto", sequenceName = "sec_producto", allocationSize = 1)
    private Integer id;


    @Column(name = "prod_nombre")  
    private String nombre;

    @Column(name = "prod_categoria")
    private String categoria;

    @Column(name = "prod_stock")
    private Integer stock;

    @Column(name = "prod_precio")
    private BigDecimal precio;


    @Column(name="prod_codigo_barras")
    private String codigoBarras;

    
    @OneToMany(mappedBy = "producto")
    private List<DetalleFactura> detalles;

}
