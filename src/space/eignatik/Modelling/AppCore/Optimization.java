package space.eignatik.Modelling.AppCore;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Optimization {
    private double a = 4;
    private double b = 1;
    private double step = 0.1;
    private double x1 = 2;
    private double x2 = 2;
    private double result;
    private List<Point> visitedPoints;

    void calculate() {
        visitedPoints = new ArrayList<>();
        result = getFunctionResultInPoints(x1, x2);
        double temp;
        while(true) {
            System.out.println(String.format("Result is %1.5f at [%1.5f:%1.5f]", result, x1, x2));
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
        return Math.pow((x1/a), 2) + Math.pow((x2/b), 2);
//        return 100 * pow((pow(x1, 2) - x2), 2) + pow((1-x1), 2);
    }

    List<Point> getVisitedPoints() {
        return visitedPoints;
    }
}
