package rectangle;

/**
 * 5-3 클래스와 객체 — 직사각형
 * 가로·세로를 필드로 가지고, 넓이와 둘레를 계산한다.
 * 필드는 private으로 숨기고 생성자에서만 값을 받는다. (캡슐화)
 */
public class Rectangle {

    private final int width;  // 가로
    private final int height; // 세로

    /** 가로·세로가 0 이하면 직사각형이 될 수 없으므로 객체를 만들지 않는다. */
    public Rectangle(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "가로와 세로는 0보다 커야 합니다. (가로=" + width + ", 세로=" + height + ")");
        }
        this.width = width;   // this.width = 필드, width = 매개변수
        this.height = height;
    }

    /** 넓이 = 가로 × 세로 */
    public int area() {
        return width * height;
    }

    /** 둘레 = 2 × (가로 + 세로) */
    public int perimeter() {
        return 2 * (width + height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /** println(객체)로 출력할 때 자동으로 호출된다. (Object의 toString 재정의) */
    @Override
    public String toString() {
        return "Rectangle(가로=" + width + ", 세로=" + height + ")";
    }
}
