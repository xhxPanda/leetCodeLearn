package marchallange;

public class GenerateRandomPointCircle {
    private double x, y, radius;
    public GenerateRandomPointCircle(double radius, double x_center, double y_center) {
        this.x = x_center;
        this.y = y_center;
        this.radius = radius;
    }

    public double[] randPoint() {
        double r = Math.sqrt(Math.random() * radius *radius);
        double a = Math.PI * 2 * Math.random();
        return new double[]{r * Math.cos(a) + x, r * Math.sin(a) + y};
    }
}
