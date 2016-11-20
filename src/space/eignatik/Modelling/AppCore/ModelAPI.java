package space.eignatik.Modelling.AppCore;

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
        model.showResults();
    }
}
