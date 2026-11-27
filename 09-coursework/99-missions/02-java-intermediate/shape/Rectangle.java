package shape;

/**
 * 사각형: 넓이 = 가로 × 세로
 * 5-3의 rectangle.Rectangle과 이름이 같지만 패키지가 달라 충돌하지 않는다.
 */
public class Rectangle implements Shape {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "가로와 세로는 0보다 커야 합니다. (가로=" + width + ", 세로=" + height + ")");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String name() {
        return "사각형";
    }

    @Override
    public String toString() {
        return "사각형(가로=" + width + ", 세로=" + height + ")";
    }
}
