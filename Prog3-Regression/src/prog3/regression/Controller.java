/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog3.regression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author felipe
 */
public class Controller {

    public Controller() {
    }

    public ListaLigada populateListFromFile(String path, String xLabel,
            String yLabel) {
        ListaLigada list = new ListaLigada();
        int lineCounter = 0;
        String[] valuesX = null;
        String[] valuesY = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                if (xLabel.equals("Estimated Proxy Size")
                        && yLabel.equals("Plan Added and Modified Size")) {
                    if (lineCounter == 0) {
                        valuesX = separateByComma(sCurrentLine);
                        for (String valuesX1 : valuesX) {
                            Nodo node = new Nodo(Double.valueOf(valuesX1), null);
                            list.insertarAlFinal(node);
                        }

                    } else if (lineCounter == 1) {
                        valuesY = separateByComma(sCurrentLine);
                        Nodo n = list.getCabeza().getAnterior();
                        int i = 0;
                        while (n != null) {
                            n.setDatoY(Double.valueOf(valuesY[i]));
                            n = n.getSiguiente();
                            i++;
                        }
                    }

                } else if (xLabel.equals("Estimated Proxy Size")
                        && yLabel.equals("Actual Added and Modified Size")) {
                    if (lineCounter == 0) {
                        valuesX = separateByComma(sCurrentLine);
                        for (String valuesX1 : valuesX) {
                            Nodo node = new Nodo(Double.valueOf(valuesX1), null);
                            list.insertarAlFinal(node);
                        }

                    } else if (lineCounter == 2) {
                        valuesY = separateByComma(sCurrentLine);
                        Nodo n = list.getCabeza().getAnterior();
                        int i = 0;
                        while (n != null) {
                            n.setDatoY(Double.valueOf(valuesY[i]));
                            n = n.getSiguiente();
                            i++;
                        }
                    }

                } else if (xLabel.equals("Estimated Proxy Size")
                        && yLabel.equals("Actual Development Hours")) {
                    if (lineCounter == 0) {
                        valuesX = separateByComma(sCurrentLine);
                        for (String valuesX1 : valuesX) {
                            Nodo node = new Nodo(Double.valueOf(valuesX1), null);
                            list.insertarAlFinal(node);
                        }

                    } else if (lineCounter == 3) {
                        valuesY = separateByComma(sCurrentLine);
                        Nodo n = list.getCabeza().getAnterior();
                        int i = 0;
                        while (n != null) {
                            n.setDatoY(Double.valueOf(valuesY[i]));
                            n = n.getSiguiente();
                            i++;
                        }
                    }

                } else if (xLabel.equals("Plan Added and Modified Size")
                        && yLabel.equals("Actual Added and Modified Size")) {
                    if (lineCounter == 1) {
                        valuesX = separateByComma(sCurrentLine);
                        for (String valuesX1 : valuesX) {
                            Nodo node = new Nodo(Double.valueOf(valuesX1), null);
                            list.insertarAlFinal(node);
                        }

                    } else if (lineCounter == 2) {
                        valuesY = separateByComma(sCurrentLine);
                        Nodo n = list.getCabeza().getAnterior();
                        int i = 0;
                        while (n != null) {
                            n.setDatoY(Double.valueOf(valuesY[i]));
                            n = n.getSiguiente();
                            i++;
                        }
                    }

                } else if (xLabel.equals("Plan Added and Modified Size")
                        && yLabel.equals("Actual Development Hours")) {
                    if (lineCounter == 1) {
                        valuesX = separateByComma(sCurrentLine);
                        for (String valuesX1 : valuesX) {
                            Nodo node = new Nodo(Double.valueOf(valuesX1), null);
                            list.insertarAlFinal(node);
                        }

                    } else if (lineCounter == 3) {
                        valuesY = separateByComma(sCurrentLine);
                        Nodo n = list.getCabeza().getAnterior();
                        int i = 0;
                        while (n != null) {
                            n.setDatoY(Double.valueOf(valuesY[i]));
                            n = n.getSiguiente();
                            i++;
                        }
                    }

                } else if (xLabel.equals("Actual Added and Modified Size")
                        && yLabel.equals("Actual Development Hours")) {
                    if (lineCounter == 2) {
                        valuesX = separateByComma(sCurrentLine);
                        for (String valuesX1 : valuesX) {
                            Nodo node = new Nodo(Double.valueOf(valuesX1), null);
                            list.insertarAlFinal(node);
                        }

                    } else if (lineCounter == 3) {
                        valuesY = separateByComma(sCurrentLine);
                        Nodo n = list.getCabeza().getAnterior();
                        int i = 0;
                        while (n != null) {
                            n.setDatoY(Double.valueOf(valuesY[i]));
                            n = n.getSiguiente();
                            i++;
                        }
                    }

                }
                System.out.println(sCurrentLine);
                lineCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String[] separateByComma(String sCurrentLine) {
        return sCurrentLine.split(",");
    }
}
