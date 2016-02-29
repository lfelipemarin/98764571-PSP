/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadisticos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class Estadisticos {

    private static final String RUTA = "numeros.txt";
    private static final String RUTA1 = "numeros1.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Estimate Proxy Size
            Archivo archivo = new Archivo();
            String string = archivo.leerArchivo(RUTA);
            ListaLigada lista = archivo.separarPorComas(string);
            Operaciones operaciones = new Operaciones();
            Double media = operaciones.calcularMedia(lista);
            Double desviacion = operaciones.calcularDesviacion(lista);
            System.out.println("La media es: " + media);
            System.out.println("La desviacion es: " + desviacion);

            //Development Hours
            String string1 = archivo.leerArchivo(RUTA1);
            ListaLigada lista1 = archivo.separarPorComas(string1);
            Double media1 = operaciones.calcularMedia(lista1);
            Double desviacion1 = operaciones.calcularDesviacion(lista1);
            System.out.println("La media1 es: " + media1);
            System.out.println("La desviacion1 es: " + desviacion1);
        } catch (IOException ex) {
            Logger.getLogger(Estadisticos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
