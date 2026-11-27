package concurrency;

/**
 * 5-2 스레드 — Runnable 구현
 * 같은 메시지를 정해진 횟수만큼 출력한다. 출력 사이에 잠깐 쉬어서 다른 스레드가 끼어들 틈을 만든다.
 */
public class MessageTask implements Runnable {

    private final String message;
    private final int count;

    public MessageTask(String message, int count) {
        this.message = message;
        this.count = count;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName(); // 이 코드를 실행 중인 스레드
        for (int i = 1; i <= count; i++) {
            System.out.println("[" + threadName + "] " + message + " (" + i + "/" + count + ")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // 중단 요청을 받으면 중단 상태를 되살리고 작업을 끝낸다 (예외를 그냥 삼키지 않음)
                Thread.currentThread().interrupt();
                System.out.println("[" + threadName + "] 중단됨");
                return;
            }
        }
    }
}
