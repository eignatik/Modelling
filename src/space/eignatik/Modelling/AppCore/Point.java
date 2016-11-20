package space.eignatik.Modelling.AppCore;

public class Point {
    private double x1;
    private double x2;

    public Point(){
        this.x1 = 2;
        this.x2 = 2;
    }

    public Point(double x1, double x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    @Override
    public String toString() {
        return String.format("%1.5f %1.5f", x1, x2);
    }
}
