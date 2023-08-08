package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @Column(name="fact_id")
    @GeneratedValue(generator = "sec_factura", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_factura", sequenceName = "sec_factura", allocationSize = 1)
    private Integer id;

    @Column(name = "fact_cedula_cliente")
    private String cedulaCliente;

    @Column(name = "fact_fecha")
    private LocalDateTime fecha;

    @Column(name = "fact_total_factura")
    private BigDecimal totalFactura;

    @OneToMany(mappedBy = "factura", cascade =  CascadeType.ALL)
    private List<DetalleFactura> detalles;
}
