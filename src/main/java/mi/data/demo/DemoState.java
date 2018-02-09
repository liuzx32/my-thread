package mi.data.demo;

public class DemoState {

    // NEW
    public static void NEW() {
        Thread t = new Thread ();
        System. out.println(t.getState());
    }

    // RUNNABLE
    public static void RUNNABLE() {
        Thread t = new Thread(){

            public void run(){
                for(int i=0; i<Integer.MAX_VALUE; i++){
                    System. out.println(i);
                }
            }

        };
        t.start();
        System.out.println(t.getState());
    }

    // BLOCKED
    public static void BLOCKED() {
        final Object lock = new Object();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<Integer.MAX_VALUE; i++){

                    synchronized (lock) {
                        System. out.println(i);
                    }

                }
            }
        };
        Thread t1 = new Thread(run);
        t1.setName("t1");
        Thread t2 = new Thread(run);
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    // WAITING
    public static void WAITING() {
        final Object lock = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int i = 0;
                while(true) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                        System. out.println(i++);
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while(true ){
                    synchronized (lock) {
                        for(int i = 0; i< 10000000; i++){
                            System. out.println(i);
                        }
                        lock.notifyAll();
                    }
                }
            }
        };
        t1.setName("^^t1^^");
        t2.setName("^^t2^^");
        t1.start();
        t2.start();
    }

    // TIMED_WAITING
    public static void TIMED_WAITING() {
        int i = 0;
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait(60 * 1000L);
            } catch (InterruptedException e) {
            }
            System.out.println(i++);
        }
        synchronized (lock) {
            try {
                Thread.sleep(30*1000L);
            } catch (InterruptedException e) {
            }
            lock.notifyAll();
        }
    }

    // TERMINATED
    public static void TERMINATED() {
        Thread t1 = new Thread();
        t1.start();
        System. out.println(t1.getState());
        try {
            Thread. sleep(1000L);
        } catch (InterruptedException e) {
        }
        System. out.println(t1.getState());
    }
}
