package shapes;

public abstract class Shape implements Comparable<Shape> {
    protected double height;

    public Shape(double height) {
        this.height = height;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.height, other.height);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public abstract double calcVolume();

    public abstract double calcBaseArea();

    public static Shape parse(String shapeData) {
        String[] parts = shapeData.split(" ");
        String shapeType = parts[0].trim();

        try {
            switch (shapeType) {
                case "Cone":
                    double height = Double.parseDouble(parts[1].trim());
                    double radius = Double.parseDouble(parts[2].trim());
                    return new Cone(radius, height);
                case "Cylinder":
                    height = Double.parseDouble(parts[1].trim());
                    radius = Double.parseDouble(parts[2].trim());
                    return new Cylinder(radius, height);
                case "OctagonalPrism":
                    double side = Double.parseDouble(parts[1].trim());
                    height = Double.parseDouble(parts[2].trim());
                    return new OctagonalPrism(side, height);
                case "PentagonalPrism":
                    side = Double.parseDouble(parts[1].trim());
                    height = Double.parseDouble(parts[2].trim());
                    return new PentagonalPrism(side, height);
                case "Pyramid":
                    height = Double.parseDouble(parts[1].trim());
                    double baseSide = Double.parseDouble(parts[2].trim());
                    return new Pyramid(baseSide, height);
                case "SquarePrism":
                    height = Double.parseDouble(parts[1].trim());
                    side = Double.parseDouble(parts[2].trim());
                    return new SquarePrism(side, height);
                case "TriangularPrism":
                    height = Double.parseDouble(parts[1].trim());
                    side = Double.parseDouble(parts[2].trim());
                    return new TriangularPrism(side, height);
                default:
                    throw new IllegalArgumentException("Unknown shape type: " + shapeType);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid shape data: " + shapeData, e);
        }
    }

    public String getProperty(String property) {
        switch (property) {
            case "v":
                return "Volume: " + String.valueOf(calcVolume());
            case "a":
                return "Area: " + String.valueOf(calcBaseArea());
            case "h":
                return "Height: " + String.valueOf(height);
            default:
                throw new IllegalArgumentException("Unknown property: " + property);
        }
    }

}
