/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadisticos;

/**
 *
 * @author felipe
 */
public class Operaciones {

    public Double calcularMedia(ListaLigada numeros) {
        Double suma = 0.0;
        Double numero;
        Nodo n = numeros.getCabeza().getAnterior();
        while (n != null) {
            numero = (Double) n.getDato();
            suma += numero;
            n = n.getSiguiente();
        }
        return suma / numeros.getTamano();
    }

    Double calcularDesviacion(ListaLigada numeros) {
        Double suma = 0.0;
        Double media = calcularMedia(numeros);
        Double numero;
        Nodo n = numeros.getCabeza().getAnterior();
        while (n != null) {
            numero = (Double) n.getDato();
            suma += Math.pow((numero - media), 2);
            n = n.getSiguiente();
        }

        return Math.sqrt((suma / (numeros.getTamano() - 1)));
    }

}
