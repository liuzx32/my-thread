package mi.data.blocked;

public class WaitTest {

	public static void main(String[] args) {
		final WaitTest test = new WaitTest();
		new Thread(new Runnable() {
			@Override
			public void run() {
				test.testWait();
			}
		}).start();
	}

	// 增加Synchronized关键字
	public synchronized void testWait() {
		System.out.println("Start-----");
		try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End-------");
	}
}
