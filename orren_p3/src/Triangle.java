public class Triangle extends Shape3D {
    public Triangle(double x, double y) {
        super();
        length = x;
        width = y;
    }

    protected String name = "triangle";
    protected double length, width;

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return (length*width)/2;
    }
}
