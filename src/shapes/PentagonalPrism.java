package shapes;

public class PentagonalPrism extends Shape {
    private double side;

    public PentagonalPrism(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));
    }
}
