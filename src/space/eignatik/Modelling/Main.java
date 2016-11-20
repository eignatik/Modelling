package space.eignatik.Modelling;

import space.eignatik.Modelling.AppCore.CustomRandom;
import space.eignatik.Modelling.AppCore.Model;
import space.eignatik.Modelling.AppCore.ModelAPI;

public class Main {
    private static ModelAPI modelAPI = new ModelAPI();
    public static void main(String[] args) {
        modelAPI.operateWithModel(20, 0.25);
    }
}
