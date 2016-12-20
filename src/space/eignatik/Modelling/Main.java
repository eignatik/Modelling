package space.eignatik.Modelling;

import space.eignatik.Modelling.AppCore.CustomRandom;
import space.eignatik.Modelling.AppCore.Model;
import space.eignatik.Modelling.AppCore.ModelAPI;

public class Main {
    private static ModelAPI modelAPI = new ModelAPI();
    public static void main(String[] args) {
//        modelAPI.checkRandom(0.1, 30000);
//        System.out.println("\n");
//        modelAPI.checkRandom(0.05, 30000);
//        modelAPI.getRandomValues(0.2);
//        modelAPI.operateWithModel(2, 0.25);
//        modelAPI.calculateOptimization();
        Model model = new Model(2.98, 2.0);
        double[] yExper = model.getArrayY();
        CustomRandom random = new CustomRandom(0.05, yExper.length, model.getMaxY());
        yExper = random.addNoise(yExper);
        for (int i=0; i<yExper.length; i++) {
            System.out.println(yExper[i]);
        }
    }
}
