package mi.data.test;

public class MyThread extends Thread {

	public static void main(String[] args) throws Exception {
		Thread.currentThread().interrupt();
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.interrupted());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
		System.out.println(Thread.currentThread().isInterrupted());
	}
}
