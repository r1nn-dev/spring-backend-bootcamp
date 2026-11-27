package inheritance;

/**
 * 5-1 실행 클래스
 * 직원·관리자 객체를 만들어 출력하고, 오버라이딩된 toString()이 호출되는 것을 확인한다.
 */
public class InheritanceMain {

    public static void main(String[] args) {
        Employee employee = new Employee("김철수", 3_000_000);
        Manager manager = new Manager("홍길동", 5_000_000, "개발팀장");

        // 1. 객체 생성 후 출력 — println(객체)는 toString()을 자동 호출한다
        System.out.println("=== 객체 출력 ===");
        System.out.println(employee);
        System.out.println(manager);

        // 2. 상속받은 메서드: Manager에는 getName()이 없지만 Employee에서 물려받았다
        System.out.println();
        System.out.println("=== 상속받은 메서드 ===");
        System.out.println("manager.getName()     = " + manager.getName());
        System.out.println("manager.getSalary()   = " + manager.getSalary());
        System.out.println("manager.getPosition() = " + manager.getPosition());

        // 3. 부모 타입 변수에 자식 객체를 담아도 실제 객체(Manager)의 toString()이 실행된다
        System.out.println();
        System.out.println("=== 부모 타입(Employee)으로 다루기 ===");
        Employee[] staff = {employee, manager, new Manager("이영희", 4_500_000, "디자인팀장")};
        for (Employee e : staff) {
            System.out.println(e.toString() + "  ← " + e.getClass().getSimpleName() + "의 toString()");
        }
    }
}
