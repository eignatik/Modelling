package space.eignatik.Modelling.AppCore;

import java.util.ArrayList;
import java.util.List;

public class Optimization {
    private double a = 4;
    private double b = 1;
    private double step = 0.01;
    private double x1 = 4;
    private double x2 = 3;
    private double result;
    private List<Point> visitedPoints;
    private static double[] exper = new Model().getArrayY();

    private static CustomRandom random02 = new CustomRandom(0.2, 30, getMaxFromArray(exper));
    private static CustomRandom random01 = new CustomRandom(0.1, 30, getMaxFromArray(exper));
    private static CustomRandom random005 = new CustomRandom(0.05, 30, getMaxFromArray(exper));

    void calculate() {
//        exper = random01.addNoise(exper);
        exper = random02.addNoise(exper);
//        exper = random005.addNoise(exper);

        visitedPoints = new ArrayList<>();
        result = getFunctionResultInPoints(x1, x2);
        double temp;
        int i = 205;
        while(true) {
//            System.out.println(String.format("Result is %1.5f at [%1.5f:%1.5f]", result, x1, x2));
            if (i-- % 6 == 0) {
                System.out.println(result);
            }
            temp = x1;
            temp += step;
            if(checkResult(temp, x2)) {
                x1 = temp;
                visitedPoints.add(new Point(x1, x2));
                result = getFunctionResultInPoints(x1, x2);
            } else {
                temp = x1;
                temp -= step;
                if(checkResult(temp, x2)) {
                    x1 = temp;
                    visitedPoints.add(new Point(x1, x2));
                    result = getFunctionResultInPoints(x1, x2);
                } else {
                    temp = x2;
                    temp += step;
                    if(checkResult(x1, temp)) {
                        x2 = temp;
                        visitedPoints.add(new Point(x1, x2));
                        result = getFunctionResultInPoints(x1, x2);
                    } else {
                        temp = x2;
                        temp -= step;
                        if(checkResult(x1, temp)) {
                            x2 = temp;
                            visitedPoints.add(new Point(x1, x2));
                            result = getFunctionResultInPoints(x1, x2);
                        } else {
                            System.out.println("\nNo more ways\n");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(String.format("Result is %1.5f [%1.5f:%1.5f]\n", result, x1, x2));
    }

    private boolean checkResult(double x1, double x2) {
        return getFunctionResultInPoints(x1, x2) < result;
    }

    private double getFunctionResultInPoints(double x1, double x2){
//        return Math.pow((x1/a), 2) + Math.pow((x2/b), 2);
//        return 100 * pow((pow(x1, 2) - x2), 2) + pow((1-x1), 2);
        double result = 0.0;
        double[] modelY = new Model(x1, x2).getArrayY();
        for (int i=0; i<exper.length; i++) {
            result += Math.abs(exper[i] - modelY[i]);
        }
        return result;
    }

    List<Point> getVisitedPoints() {
        return visitedPoints;
    }

    private static double getMaxFromArray(double[] array) {
        double max = 0.0;
        for (int i=0; i<array.length; i++) {
            max = array[i] >= max? array[i]:max;
        }
        return max;
    }
}
