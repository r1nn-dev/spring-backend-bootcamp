package concurrency;

/**
 * 5-2 실행 클래스 — 스레드
 * Runnable을 구현한 작업 2개를 각각 스레드로 실행해 메시지가 동시에(섞여서) 출력되는 것을 확인한다.
 * 비교용으로 run()을 직접 호출하면 새 스레드 없이 순서대로 실행되는 것도 보여준다.
 */
public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        // 1. start(): 새 스레드 2개가 동시에 실행된다 → 출력 순서가 섞이고, 실행할 때마다 달라질 수 있다
        System.out.println("=== start() — 두 스레드 동시 실행 ===");
        Thread thread1 = new Thread(new MessageTask("Hello", 5), "스레드1");
        Thread thread2 = new Thread(new MessageTask("World", 5), "스레드2");

        thread1.start();
        thread2.start();

        thread1.join(); // 두 스레드가 끝날 때까지 main 스레드가 기다린다
        thread2.join();
        System.out.println("두 스레드 종료 → 스레드1=Hello, 스레드2=World 동시에 출력");

        // 2. run(): 그냥 메서드 호출이라 main 스레드에서 하나씩 순서대로 실행된다
        System.out.println();
        System.out.println("=== run() 직접 호출 (비교) — 새 스레드 없음 ===");
        new Thread(new MessageTask("Hello", 3), "스레드1").run();
        new Thread(new MessageTask("World", 3), "스레드2").run();
        System.out.println("모두 [main]에서 Hello 3번이 끝난 뒤 World 3번");
    }
}
