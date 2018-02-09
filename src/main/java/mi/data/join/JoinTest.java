package mi.data.join;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest t1 = new ThreadJoinTest("小明");
        ThreadJoinTest t2 = new ThreadJoinTest("小东");
        t1.start();
        /**
         * join方法可以传递参数，join(10)表示main线程会等待t1线程10毫秒，10毫秒过去后，
         * main线程和t1线程之间执行顺序由串行执行变为普通的并行执行
         */
        System.out.println("#main invoke t1.join");
        t1.join(1000);
        System.out.println("#main continue run...");
        t2.start();
        t2.join();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println("#main exit!!!");
    }

    static class ThreadJoinTest extends Thread {
        public ThreadJoinTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            print(this.getName());
        }
    }

    static synchronized void print(String name) {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ":" + i + "," + Thread.currentThread().getState());
        }
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getState());
            System.out.println("#thread sleep 3 seconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}