package org.kmryfv.Facturacion.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity @Getter @Setter
public class Factura {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String old;

    @Column(length = 4)
    int anio;

    @Column(length = 6)
    int numero;

    @Required
            @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Cliente cliente;

    @ElementCollection
            @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;

    @Stereotype("MEMO")
    String observaciones;
}
