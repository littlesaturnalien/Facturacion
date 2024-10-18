package org.kmryfv.Facturacion.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Files;
import org.openxava.annotations.TextArea;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Producto {
    @Id @Column(length = 9)
    int numero;

    @Column(length = 50)
    String descripciones;

    @ManyToOne
            (fetch= FetchType.LAZY, optional = true)
            @DescriptionsList
    Catalogo catalogo;

    @Files
    String fotos;

    @TextArea
    String observaciones;

}
