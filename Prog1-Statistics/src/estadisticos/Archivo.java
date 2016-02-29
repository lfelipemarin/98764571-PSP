/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadisticos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author felipe
 */
public class Archivo {

    private String ruta;

    public String leerArchivo(String ruta) throws IOException {
        this.ruta = ruta;
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine != null) {
                    line = sCurrentLine;
                }
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return line;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public ListaLigada separarPorComas(String string) {
        ListaLigada lista = new ListaLigada();
        for (String retval : string.split(",")) {
            Nodo nuevo = new Nodo(Double.parseDouble(retval));
            lista.insertarAlFinal(nuevo);
            System.out.println(retval);
        }
        return lista;
    }

}
