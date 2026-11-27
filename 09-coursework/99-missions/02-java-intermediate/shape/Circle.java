package shape;

/** 원: 넓이 = π × 반지름² */
public class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("반지름은 0보다 커야 합니다. (반지름=" + radius + ")");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String name() {
        return "원";
    }

    @Override
    public String toString() {
        return "원(반지름=" + radius + ")";
    }
}
