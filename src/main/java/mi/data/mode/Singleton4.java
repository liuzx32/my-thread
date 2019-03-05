package mi.data.mode;

public class Singleton4 {

	/**
	 * 构造函数私有，禁止外部实例化
	 */
	private Singleton4() {}

	private static class SingletonInstance {
		private static final Singleton4 singleton = new Singleton4();
	}

	public static Singleton4 getInstance() {
		return SingletonInstance.singleton;
	}
}
