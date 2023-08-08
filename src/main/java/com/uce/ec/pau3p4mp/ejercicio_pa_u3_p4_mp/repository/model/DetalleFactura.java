package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "detalle_factura")
public class DetalleFactura {

    @Id
    @Column(name="dtfa_id")
    @GeneratedValue(generator = "sec_detalle_factura", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_detalle_factura", sequenceName = "sec_detalle_factura", allocationSize = 1)
    private Integer id;

    @Column(name = "dtfa_cantidad")
    private Integer Cantidad;

    @Column(name = "dtfa_precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "dtfa_subtotal")
    private BigDecimal subtiotal;


    @ManyToOne()
    @JoinColumn(name = "dtfa_id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "dtfa_id_producto")
    private Producto producto;

    
}
