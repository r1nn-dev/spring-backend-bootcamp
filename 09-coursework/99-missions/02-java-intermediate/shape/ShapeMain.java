package shape;

/**
 * 5-5 실행 클래스
 * 서로 다른 도형을 Shape 배열 하나에 담고, 반복문 하나로 면적을 계산한다.
 * 반복문 안에는 도형 종류별 분기(if, instanceof)가 없다. 어떤 area()가 실행될지는 실제 객체가 정한다.
 */
public class ShapeMain {

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 5),
                new Triangle(6, 5)
        };

        System.out.println("=== 도형별 넓이 ===");
        double total = 0;
        StringBuilder summary = new StringBuilder();
        for (Shape shape : shapes) {
            double area = shape.area(); // 선언 타입은 Shape, 실행되는 area()는 Circle/Rectangle/Triangle의 것
            total += area;
            System.out.printf("%s → 넓이 = %.1f%n", shape, area); // 한글은 폭이 달라 %-20s 정렬이 어긋나므로 화살표로 구분

            if (!summary.isEmpty()) {
                summary.append(", ");
            }
            summary.append(shape.name()).append('=').append(String.format("%.1f", area));
        }

        System.out.println();
        System.out.printf("넓이 합계 = %.1f%n", total);
        System.out.println(summary);
    }
}
