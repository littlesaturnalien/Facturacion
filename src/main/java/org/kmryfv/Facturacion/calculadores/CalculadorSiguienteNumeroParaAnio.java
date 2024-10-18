package org.kmryfv.Facturacion.calculadores;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;

public class CalculadorSiguienteNumeroParaAnio implements ICalculator {
    @Getter @Setter
    int anio;

    @Override
    public Object calculate() throws Exception {
        Query query = XPersistence.getManager()
                .createQuery("select max(f.numero) from Factura f where f.anio = :anio");
        query.setParameter("anio", anio);
        Integer ultimoNumero = (Integer) query.getSingleResult();
        return ultimoNumero == null ? 1: ultimoNumero + 1;
    }
}
