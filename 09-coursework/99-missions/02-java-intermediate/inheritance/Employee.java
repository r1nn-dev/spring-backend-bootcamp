package inheritance;

/**
 * 5-1 상속과 메서드 오버라이딩 — 직원 (부모 클래스)
 * 이름과 급여를 가진다. 필드는 private으로 두고 자식 클래스는 getter로 읽는다.
 */
public class Employee {

    private final String name;
    private final int salary; // 원 단위 월급. int 최대값(약 21억)이면 충분

    public Employee(String name, int salary) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("급여는 0 이상이어야 합니다. (급여=" + salary + ")");
        }
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    /** Object의 toString()을 재정의한다. */
    @Override
    public String toString() {
        return "직원: 이름=" + name + ", 급여=" + salary;
    }
}
