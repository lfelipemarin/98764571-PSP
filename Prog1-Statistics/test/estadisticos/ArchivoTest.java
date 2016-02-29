/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadisticos;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class ArchivoTest {

    public ArchivoTest() {
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

    @Test(expected = java.io.FileNotFoundException.class)
    public void testLeerArchivoNoEncontrado() throws IOException {
        Archivo archivo = new Archivo();
        archivo.leerArchivo("");
    }

    @Test
    public void testLeerArchivoEncontrado() {
        Archivo archivo = new Archivo();
        String archActual = "numeros.txt";
        String archExpected = "";
        try {
            archivo.leerArchivo(archActual);
            archExpected = archivo.getRuta();

        } catch (IOException ex) {
            Logger.getLogger(ArchivoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals("Las rutas son diferentes", archExpected, archActual);

    }

    @Test(expected = NumberFormatException.class)
    public void testSepararPorComasFalla() {
        Archivo archivo = new Archivo();
        String string = "13.123.123.4234.234";
        String[] expected = {"13", "123", "123", "4234", "234"};
        String[] actual = new String[10];

        ListaLigada lista = archivo.separarPorComas(string);

        Nodo n = lista.getCabeza().getAnterior();
        int i = 0;
        while (n != null) {
            actual[i] = String.valueOf(n.getDato());
            n = n.getSiguiente();
            i++;
        }
        assertFalse(Arrays.equals(actual, expected));
    }

    @Test
    public void testSepararPorComasPasa() {
        Archivo archivo = new Archivo();

        String string = "13,123,123,4234,234";
        String[] expected = {"13.0", "123.0", "123.0", "4234.0", "234.0"};
        String[] actual = new String[5];

        ListaLigada lista = archivo.separarPorComas(string);

        Nodo n = lista.getCabeza().getAnterior();
        int i = 0;
        while (n != null) {
            actual[i] = String.valueOf(n.getDato());
            n = n.getSiguiente();
            i++;
        }
        assertTrue(Arrays.equals(actual, expected));
    }

}
