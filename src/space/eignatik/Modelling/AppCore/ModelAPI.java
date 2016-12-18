package space.eignatik.Modelling.AppCore;

import java.util.List;

public class ModelAPI {
    private static CustomRandom random02 = new CustomRandom(0.2, 30);
    private static CustomRandom random01 = new CustomRandom(0.1, 30);
    private static CustomRandom random005 = new CustomRandom(0.05, 30);

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
        for(Point point : list) {
            System.out.println(point);
        }
    }
}
