public class Cube extends Shape3D {
    public Cube(double x) {
        super();
        length = x;
    }

    protected String name = "cube";
    protected double length;

    @Override
    public double getVolume() {
        return (length*length*length);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return 6*(length*length);
    }
}
