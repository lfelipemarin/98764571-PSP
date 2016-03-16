/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog3.regression;

/**
 *
 * @author felipe
 */
public class Nodo {

    private Object datoX;
    private Object datoY;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Object datoX, Object datoY) {
        this.anterior = null;
        this.siguiente = null;
        this.datoX = datoX;
        this.datoY = datoY;
    }

    public Object getDatoX() {
        return datoX;
    }

    public void setDatoX(Object datoX) {
        this.datoX = datoX;
    }

    public Object getDatoY() {
        return datoY;
    }

    public void setDatoY(Object datoY) {
        this.datoY = datoY;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

}
