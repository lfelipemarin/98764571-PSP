/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.loc.counter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CounterTest {

    public CounterTest() {
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
    public void testCountLOC() {
        ArrayList<String> pathArray = new ArrayList<>();
        String path1 = "src/prog2/loc/counter/Counter.java";
        String path2 = "src/prog2/loc/counter/Prog2LOCCounter.java";
        int expected = 55;
        pathArray.add(path1);
        pathArray.add(path2);
        Counter counter = new Counter(pathArray);
        int LOC = counter.countLOC();
        assertEquals("Lineas de codigo diferentes", expected, LOC);
    }

    @Test
    public void testCountMethods() {
        ArrayList<String> pathArray = new ArrayList<>();
        String path1 = "src/prog2/loc/counter/Counter.java";
        String path2 = "src/prog2/loc/counter/Prog2LOCCounter.java";
        pathArray.add(path1);
        pathArray.add(path2);
        Counter counter = new Counter(pathArray);
        int expected = 10;
        int counterMethods = counter.countMethods();
        assertEquals("Numero de metodos no coincide", expected, counterMethods);
    }

    @Test
    public void testCountLOCDirectory() {
        ArrayList<String> arrayPaths = new ArrayList<>();
        try {
            Files.walk(Paths.get("src/prog2/loc/counter/")).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    if (filePath.toString().endsWith("java")) {
                        System.out.println(filePath.toString());
                        arrayPaths.add(filePath.toString());
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Prog2LOCCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        int expected = 150;
        Counter counter = new Counter(arrayPaths);
        int LOC = counter.countLOC();
        assertEquals("Lineas de codigo diferentes", expected, LOC);
    }

}
