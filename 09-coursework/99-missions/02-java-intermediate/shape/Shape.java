package shape;

/**
 * 5-5 인터페이스와 다형성 — 도형
 * 넓이를 계산하는 방법은 도형마다 다르므로 규약(메서드 이름·반환형)만 정한다.
 */
public interface Shape {

    /** 넓이 */
    double area();

    /** 출력용 도형 이름 (원, 사각형, 삼각형) */
    String name();
}
