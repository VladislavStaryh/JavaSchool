import sun.awt.windows.ThemeReader;

public class Task implements Runnable {
    String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        int sum = 0;
        System.out.println("Задание " + taskName + " в потоке " + Thread.currentThread().getName());

        for (int i = 0; i < 20000; i++) {
            sum += i * i;
            for (int j = 0; j < 20000; j++) {
                sum += j * i;
            }
        }
        System.out.println(sum);
        System.out.println("Задание: " + taskName + " в потоке " + Thread.currentThread().getName());
    }
}
