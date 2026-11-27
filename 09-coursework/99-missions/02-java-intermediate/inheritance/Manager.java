package inheritance;

/**
 * 5-1 상속과 메서드 오버라이딩 — 관리자 (자식 클래스)
 * 직원의 이름·급여를 물려받고 직책을 추가한다.
 */
public class Manager extends Employee {

    private final String position; // 직책

    public Manager(String name, int salary, String position) {
        super(name, salary); // 부모 생성자로 이름·급여 초기화 (생성자 첫 줄)
        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException("직책은 비어 있을 수 없습니다.");
        }
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    /** Employee의 toString()을 재정의한다. 부모의 private 필드는 getter로 읽는다. */
    @Override
    public String toString() {
        return "관리자: 이름=" + getName() + ", 급여=" + getSalary() + ", 직책=" + position;
    }
}
