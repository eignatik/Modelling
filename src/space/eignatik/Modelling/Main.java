package space.eignatik.Modelling;

import space.eignatik.Modelling.AppCore.ModelAPI;

public class Main {
    private static ModelAPI modelAPI = new ModelAPI();
    public static void main(String[] args) {
//        modelAPI.checkRandom(0.2, 10000);
//        modelAPI.getRandomValues(0.2);
//        modelAPI.operateWithModel(20, 0.25);
        modelAPI.calculateOptimization();
    }
}
