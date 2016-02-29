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
public class OperacionesTest {

    public OperacionesTest() {
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
    public void testMedia() {
        ListaLigada numeros = new ListaLigada();
        Nodo n = new Nodo(2.8);
        Nodo n1 = new Nodo(6.4);
        Nodo n2 = new Nodo(7.6);
        Nodo n3 = new Nodo(5.4);
        Nodo n4 = new Nodo(4.5);
        Double expected = 5.339999999999999;
        numeros.insertarAlFinal(n);
        numeros.insertarAlFinal(n1);
        numeros.insertarAlFinal(n2);
        numeros.insertarAlFinal(n3);
        numeros.insertarAlFinal(n4);
        Operaciones operaciones = new Operaciones();
        Double actual = operaciones.calcularMedia(numeros);
        assertEquals("Las medias no coinciden", expected, actual);

    }

    @Test
    public void testDesviacion() {
        ListaLigada numeros = new ListaLigada();
        Nodo n = new Nodo(2.8);
        Nodo n1 = new Nodo(6.4);
        Nodo n2 = new Nodo(7.6);
        Nodo n3 = new Nodo(5.4);
        Nodo n4 = new Nodo(4.5);
        numeros.insertarAlFinal(n);
        numeros.insertarAlFinal(n1);
        numeros.insertarAlFinal(n2);
        numeros.insertarAlFinal(n3);
        numeros.insertarAlFinal(n4);
        Operaciones operaciones = new Operaciones();
        Double expected = 1.8297540818372289;
        Double media = operaciones.calcularMedia(numeros);
        Double desviacionActual = operaciones.calcularDesviacion(numeros);
        assertEquals("Las desviaciones no coinciden", expected, desviacionActual);

    }

}
