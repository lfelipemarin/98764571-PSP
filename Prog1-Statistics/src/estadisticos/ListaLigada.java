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
public class ListaLigada {

    private Nodo cabeza;
    private Nodo primero;
    private Nodo ultimo;
    private int tamano;

    public ListaLigada() {
        cabeza = new Nodo(null);
        primero = null;
        ultimo = null;
        cabeza.setAnterior(primero);
        cabeza.setSiguiente(ultimo);
        tamano = 0;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void insertarAlFinal(Nodo nuevo) {
        if (esVacia()) {
            cabeza.setSiguiente(nuevo);
            cabeza.setAnterior(nuevo);
            nuevo.setAnterior(cabeza);
            nuevo.setSiguiente(null);
            setPrimero(nuevo);
            setUltimo(nuevo);
            tamano++;
        } else {
            cabeza.setSiguiente(nuevo);
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(null);
            setUltimo(nuevo);
            tamano++;
        }
    }

    boolean esVacia() {
        return primero == null;
    }
}
