package shapes;

public class Cone extends Shape {
    private double radius;

    public Cone(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
