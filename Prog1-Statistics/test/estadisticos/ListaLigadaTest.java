/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadisticos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class ListaLigadaTest {

    public ListaLigadaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEsVacia() {
        ListaLigada lista = new ListaLigada();
        assertTrue(lista.esVacia());
    }

    @Test
    public void testInsertarNuevoNodo() {
        ListaLigada lista = new ListaLigada();
        Object dato = "3";
        Nodo nuevo = new Nodo(dato);
        lista.insertarAlFinal(nuevo);
        Nodo ultimo = lista.getUltimo();
        assertEquals("Los nodos insertados son diferentes", ultimo, nuevo);
    }

    @Test
    public void testInsertarVariosNodos() {
        ListaLigada lista = new ListaLigada();
        Object dato = "3";
        for (int i = 0; i < 10; i++) {
            Nodo nuevo = new Nodo(dato);
            lista.insertarAlFinal(nuevo);
            Nodo ultimo = lista.getUltimo();
            assertEquals("Los nodos insertados son diferentes", ultimo, nuevo);
        }
    }

    @Test
    public void testTamano() {
        ListaLigada lista = new ListaLigada();
        Object dato = "3";
        int tamanoActual = 10;
        for (int i = 0; i < 10; i++) {
            Nodo nuevo = new Nodo(dato);
            lista.insertarAlFinal(nuevo);
        }
        int tamanoExpected = lista.getTamano();
        assertEquals("El tamaño es erroneo", tamanoExpected, tamanoActual);
    }

    @Test
    public void testInsertarYObtenerDatos() {
        ListaLigada lista = new ListaLigada();
        Object dato = "3";
        int i;
        for (i = 0; i < 10; i++) {
            Nodo nuevo = new Nodo(i);
            lista.insertarAlFinal(nuevo);
        }
        Nodo n = lista.getCabeza().getAnterior();
        i = 0;
        while (n != null) {
            assertEquals("Datos erroneos", i, n.getDato());
            n = n.getSiguiente();
            i++;
        }

    }

}
