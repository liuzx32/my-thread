package mi.data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) throws Exception {
        new App().testPool();
    }

    private ExecutorService executor = Executors.newFixedThreadPool(3);

    public void testPool() throws Exception {
        IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));
        stop(executor);
        System.out.println(count);
        System.out.println(ac.get());
    }

    private int count = 0;
    private AtomicInteger ac = new AtomicInteger(0);
    private void increment() {
        synchronized (this) {
            count = count + 1;
        }
        ac.incrementAndGet();
    }

    private void stop(ExecutorService executor) throws Exception {
        Thread.sleep(10);
        executor.shutdown();
    }
}
