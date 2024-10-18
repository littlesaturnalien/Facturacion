package org.kmryfv.Facturacion.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.kmryfv.Facturacion.calculadores.CalculadorSiguienteNumeroParaAnio;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

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

    @DefaultValueCalculator(CurrentYearCalculator.class)
    @Column(length = 4)
    int anio;

    @Column(length = 6)
            @DefaultValueCalculator(value = CalculadorSiguienteNumeroParaAnio.class,
            properties = @PropertyValue(name = "anio"))
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
