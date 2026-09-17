package Wrappers;

import com.aventstack.extentreports.ExtentTest;

public class TestLogger {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static void setTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static void info(String message) {
		System.out.println("[INFO] " + message);

		if (extentTest.get() != null) {
			extentTest.get().info(message);
		}
	}

	public static void pass(String message) {
		System.out.println("[PASS] " + message);

		if (extentTest.get() != null) {
			extentTest.get().pass(message);
		}
	}

	public static void fail(String message) {
		System.out.println("[FAIL] " + message);

		if (extentTest.get() != null) {
			extentTest.get().fail(message);
		}
	}

	public static void removeTest() {
		extentTest.remove();
	}
}
