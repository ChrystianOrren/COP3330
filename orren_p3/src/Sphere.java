public class Sphere extends Shape3D {
    public Sphere(double x) {
        super();
        radius = x;
    }

    protected String name = "sphere";
    protected double radius;

    @Override
    public double getVolume() {
        return ((4.0/3.0)*Math.PI*Math.pow(radius, 3));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return (4*Math.PI*(radius*radius));
    }
}
