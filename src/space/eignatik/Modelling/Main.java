package space.eignatik.Modelling;

import space.eignatik.Modelling.AppCore.Model;

public class Main {
    public static void main(String[] args) {
        operateWithModel();
    }

    private static void operateWithModel(){
        Model model = new Model();
        model.setPrintStep(20);
        model.setStep(0.05);
        model.showResults();
    }
}
