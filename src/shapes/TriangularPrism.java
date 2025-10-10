package shapes;

public class TriangularPrism extends Shape {
    private double side;

    public TriangularPrism(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }

}
