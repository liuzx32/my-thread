package mi.data.mode;

public class Singleton2 {

	private static volatile Singleton2 singleton;

	/**
	 * 构造函数私有，禁止外部实例化
	 */
	private Singleton2() {};

	public static synchronized Singleton2 getInstance() {
		if (singleton == null) {
			singleton = new Singleton2();
		}
		return singleton;
	}
}
