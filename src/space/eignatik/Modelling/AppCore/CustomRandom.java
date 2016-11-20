package space.eignatik.Modelling.AppCore;

import java.util.Random;

import static java.lang.Math.*;

public class CustomRandom {
    private double[] values;
    private Random random;
    private double dy = 0.2; //can be 0.1 or 0.2

    CustomRandom(double dy) {
        this.dy = dy;
        random = new Random();
        values = new double[30];
        fillValues();
        printValues();
    }

    CustomRandom(double dy, int arraySize) {
        this.dy = dy;
        random = new Random();
        values = new double[arraySize];
        fillValues();
    }

    private void fillValues() {
        for(int i = 0; i < values.length; i++) {
            values[i] = getValueByMullerMethod() * dy;
        }
    }

    private double getValueByMullerMethod() {
        double first = (double) random.nextInt(98)/100 + 0.01;
        double second = (double) random.nextInt(98)/100 + 0.01;
        return sqrt(-2 * log(first)) * cos(2 * PI * second);
    }

    void checkRandom() {
        sortArray();
        printPeriodElements();
    }

    private void sortArray() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i; j++) {
                if (j >= values.length-1) {
                    break;
                }
                if (values[j] > values[j+1]) {
                    double tmp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = tmp;
                }
            }
        }
    }

    private void printPeriodElements() {
        double step = getStep(10);
        int count = 0;
        double period = values[0] + step;

        for(int i = 0; i < values.length; i++) {
            if(values[i] <= period) {
                count++;
            } else {
                System.out.println(String.format("[%1.2f | %1.2f]\t%d", period-step, period, count));
                count = 0;
                period += step;
            }
        }
    }

    private double getStep(int count) {
        return (values[values.length-1] - values[0])/count;
    }

    private void printValues() {
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + "\n");
        }
    }

    public double[] getValues() {
        return values;
    }
}
