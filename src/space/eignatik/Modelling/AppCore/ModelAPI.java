package space.eignatik.Modelling.AppCore;

import java.util.List;

public class ModelAPI {
    public void checkRandom(double dy, int size) {
        CustomRandom customRandom = new CustomRandom(dy, size);
        customRandom.checkRandom();
    }

    public double[] getRandomValues(double dy) {
        CustomRandom customRandom = new CustomRandom(dy);
        return customRandom.getValues();
    }

    public void operateWithModel(int printStep, double step) {
        Model model = new Model();
        model.setPrintStep(printStep);
        model.setStep(step);
        model.operate();
        double[] array = model.getArrayY();
        for (int i=0; i<array.length; i++) {
            System.out.println(i + "\t" + array[i]);
        }
    }

    public void calculateOptimization() {
        Optimization optimization = new Optimization();
        optimization.calculate();
        printList(optimization.getVisitedPoints());

    }

    private void printList(List<Point> list) {
        int i = 0;
        for(Point point : list) {
            if (i++ % 6 == 0) {
                System.out.println(point);
            }
        }
    }
}
