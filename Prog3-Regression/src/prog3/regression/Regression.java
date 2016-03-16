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
public class Regression {

    public double sum(ListaLigada list, String tag) {
        double sum = 0.0;
        double number;
        switch (tag) {
            case "x": {
                Nodo n = list.getCabeza().getAnterior();
                while (n != null) {
                    number = (Double) n.getDatoX();
                    sum += number;
                    n = n.getSiguiente();
                }
                return sum;
            }
            case "y": {
                Nodo n = list.getCabeza().getAnterior();
                while (n != null) {
                    number = (Double) n.getDatoY();
                    sum += number;
                    n = n.getSiguiente();
                }
                return sum;
            }
            default:
                return -1;
        }

    }

    public double sum2Pwr(ListaLigada list, String tag) {
        double sum = 0.0;
        double number;
        switch (tag) {
            case "x": {
                Nodo n = list.getCabeza().getAnterior();
                while (n != null) {
                    number = Math.pow((Double) n.getDatoX(), 2);
                    sum += number;
                    n = n.getSiguiente();
                }
                return sum;
            }
            case "y": {
                Nodo n = list.getCabeza().getAnterior();
                while (n != null) {
                    number = Math.pow((Double) n.getDatoY(), 2);
                    sum += number;
                    n = n.getSiguiente();
                }
                return sum;
            }
            default:
                return -1;
        }

    }

    public double sumXY(ListaLigada list) {
        double sum = 0.0;
        Nodo n = list.getCabeza().getAnterior();
        while (n != null) {
            sum += ((Double) n.getDatoX() * (Double) n.getDatoY());
            n = n.getSiguiente();
        }
        return sum;
    }

    public double avg(ListaLigada list, String tag) {
        double sum = 0.0;
        double number;
        switch (tag) {
            case "x": {
                Nodo n = list.getCabeza().getAnterior();
                while (n != null) {
                    number = (Double) n.getDatoX();
                    sum += number;
                    n = n.getSiguiente();
                }
                return sum / list.getTamano();
            }
            case "y": {
                Nodo n = list.getCabeza().getAnterior();
                while (n != null) {
                    number = (Double) n.getDatoY();
                    sum += number;
                    n = n.getSiguiente();
                }
                return sum / list.getTamano();
            }
            default:
                return -1;
        }
    }

    public double calcB1(ListaLigada list) {
        double sumXY;
        double sumX2;
        double xAvg;
        double yAvg;
        double b1;
        double n;

        sumXY = sumXY(list);
        sumX2 = sum2Pwr(list, "x");
        xAvg = avg(list, "x");
        yAvg = avg(list, "y");
        n = list.getTamano();

        b1 = (sumXY - (n * xAvg * yAvg)) / (sumX2 - (n * Math.pow(xAvg, 2)));

        return b1;
    }

    public double calcB0(ListaLigada list) {
        double yAvg;
        double xAvg;
        double b0;
        double b1;

        xAvg = avg(list, "x");
        yAvg = avg(list, "y");
        b1 = calcB1(list);

        b0 = yAvg - (b1 * xAvg);
        return b0;
    }

    public double calcR(ListaLigada list) {
        double sumXY;
        double sumX;
        double sumY;
        double sumX2;
        double sumY2;
        double n;
        double r;

        sumXY = sumXY(list);
        sumX = sum(list, "x");
        sumY = sum(list, "y");
        sumX2 = sum2Pwr(list, "x");
        sumY2 = sum2Pwr(list, "y");
        n = list.getTamano();

        r = ((n * sumXY) - (sumX * sumY)) / (Math.sqrt(((n * sumX2) - (Math.pow(sumX, 2))) * ((n * sumY2) - (Math.pow(sumY, 2)))));
        return r;
    }

    public double calcY(ListaLigada list, double xEst) {
        double yEst;
        double b0;
        double b1;

        b1 = calcB1(list);
        b0 = calcB0(list);

        yEst = b0 + (b1 * xEst);
        return yEst;
    }

    public double calcR2(ListaLigada list) {
        return Math.pow(calcR(list), 2);
    }
}
