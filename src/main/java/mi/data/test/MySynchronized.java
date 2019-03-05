package mi.data.test;

public class MySynchronized {

	public static Object lock = new Object();

	public static void main(String[] args) {
		testSync();
	}

	public static void testSync() {
		synchronized (lock) {
			System.out.println("test");
		}
	}
}
