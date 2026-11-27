package shape;

/** 삼각형: 넓이 = 밑변 × 높이 ÷ 2 */
public class Triangle implements Shape {

    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "밑변과 높이는 0보다 커야 합니다. (밑변=" + base + ", 높이=" + height + ")");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return base * height / 2;
    }

    @Override
    public String name() {
        return "삼각형";
    }

    @Override
    public String toString() {
        return "삼각형(밑변=" + base + ", 높이=" + height + ")";
    }
}
