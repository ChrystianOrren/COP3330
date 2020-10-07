public class Pyramid extends Shape3D {
    public Pyramid(double x, double y, double z) {
        super();
        length = x;
        width = y;
        height = z;
    }

    protected String name = "pyramid";
    protected double length, width, height;

    @Override
    public double getVolume() {
        return (length*width*height)/3;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double step1 = (length*width);
        double step2 = width * Math.sqrt((Math.pow((length/2), 2) + Math.pow(height, 2)));
        double step3 = length * Math.sqrt(Math.pow((width/2), 2) + Math.pow(height, 2));
        double area = step1 + step2 + step3;
        return area;
    }
}
