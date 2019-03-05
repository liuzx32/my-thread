package mi.data.mode;

public class Singleton0 {

	private static Singleton0 singleton = new Singleton0();

	/**
	 * 构造函数私有，禁止外部实例化
	 */
	private Singleton0() {}

	public static Singleton0 getInstance() {
		return singleton;
	}
}
