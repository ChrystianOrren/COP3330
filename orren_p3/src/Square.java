public class Square extends Shape3D {
    public Square(double x) {
        super();
        length = x;
    }

    protected String name = "square";
    protected double length;

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
        return (length*length);
    }
}
