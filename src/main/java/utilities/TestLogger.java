package utilities;

public class TestLogger {
	
	public static void info(String message) {
		System.out.println("[INFO] " + message);
	}

	public static void pass(String message) {
		System.out.println("[PASS] " + message);
	}

	public static void fail(String message) {
		System.out.println("[FAIL] " + message);
	}
}
