package shapes;

public class Pyramid extends Shape {
    private double side;

    public Pyramid(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * Math.pow(side, 2) * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }

}
