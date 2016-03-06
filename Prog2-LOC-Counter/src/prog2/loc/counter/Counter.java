/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.loc.counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Counter {

    int LOCCounter = 0;
    int methodCounter = 0;
    ArrayList<String> pathArray = new ArrayList<>();

    public Counter(ArrayList<String> pathArray) {
        this.pathArray = pathArray;
    }

    public int countLOC() {
        for (String path : pathArray) {
            int classLOCCount = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    if (sCurrentLine.endsWith("{")) {
                        classLOCCount++;
                        LOCCounter++;
                    } else if (sCurrentLine.endsWith(";")) {
                        classLOCCount++;
                        LOCCounter++;
                    }
                    System.out.println(sCurrentLine);
                }
                System.out.println("LOC for class " + path + " = "
                        + LOCCounter);
                FilesHandler.log.append("LOC for class " + path + " = "
                        + classLOCCount + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return LOCCounter;
    }

    public int countMethods() {
        for (String path : pathArray) {
            int classMethodCount = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    if (sCurrentLine.contains("public")
                            && sCurrentLine.contains("(")
                            && sCurrentLine.endsWith("{")) {
                        classMethodCount++;
                        methodCounter++;
                    } else if (sCurrentLine.contains("private")
                            && sCurrentLine.contains("(")
                            && sCurrentLine.endsWith("{")) {
                        classMethodCount++;
                        methodCounter++;
                    } else if (sCurrentLine.contains("protected")
                            && sCurrentLine.contains("(")
                            && sCurrentLine.endsWith("{")) {
                        classMethodCount++;
                        methodCounter++;
                    }
                    System.out.println(sCurrentLine);
                }
                System.out.println("Methods for class " + path + " = "
                        + classMethodCount);
                FilesHandler.log.append("Methods for class " + path + " = "
                        + classMethodCount + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return methodCounter;
    }

    public int getLOCCounter() {
        return LOCCounter;
    }

    public void setLOCCounter(int LOCCounter) {
        this.LOCCounter = LOCCounter;
    }

    public int getMethodCounter() {
        return methodCounter;
    }

    public void setMethodCounter(int methodCounter) {
        this.methodCounter = methodCounter;
    }

    public ArrayList<String> getPathArray() {
        return pathArray;
    }

    public void setPathArray(ArrayList<String> pathArray) {
        this.pathArray = pathArray;
    }

}
