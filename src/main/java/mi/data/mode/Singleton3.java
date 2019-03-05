package mi.data.mode;

public class Singleton3 {

	private static Object lock = new Object();
	private static volatile Singleton3 singleton;

	/**
	 * 构造函数私有，禁止外部实例化
	 */
	private Singleton3() {};

	public static Singleton3 getInstance() {
		if (singleton == null) {
			synchronized (lock) {
				if (singleton == null) {
					singleton = new Singleton3();
				}
			}
		}
		return singleton;
	}
}
