import java.lang.Math.*;

public class Circle extends Shape3D {
    public Circle(double x) {
        super();
        radius = x;
    }

    protected String name = "circle";
    protected double radius;

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
        return Math.PI*(radius*radius);
    }
}
