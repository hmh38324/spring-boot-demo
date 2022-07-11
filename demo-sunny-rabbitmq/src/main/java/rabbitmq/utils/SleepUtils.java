package rabbitmq.utils;

public class SleepUtils {

    /**
     * 睡眠**秒
     * @param second
     */
    public static void sleep(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
