package mi.data.blocked;

public class NotifyTest {

	public static void main(String[] args) throws InterruptedException {
		final NotifyTest test = new NotifyTest();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					test.testWait();
				}
			}).start();
		}

		synchronized (test) {
			test.notify();
		}
		Thread.sleep(3000);
		System.out.println("-----------分割线-------------");

		synchronized (test) {
			test.notifyAll();
		}
	}

	public synchronized void testWait() {
		System.out.println(Thread.currentThread().getName() + " Start-----");
		try {
			wait(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " End-------");
	}
}
