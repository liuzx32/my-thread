package mi.data.mode;

public class Singleton1 {

	private static Singleton1 singleton;

	static {
		singleton = new Singleton1();
	}

	/**
	 * 构造函数私有，禁止外部实例化
	 */
	private Singleton1() {}

	public static Singleton1 getInstance() {
		return singleton;
	}
}
