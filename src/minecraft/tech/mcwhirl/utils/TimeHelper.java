package tech.mcwhirl.utils;

public class TimeHelper {
	
	private static long lastMS = 0L;
	
	public boolean isDelayComplete(float f) {
		if (System.currentTimeMillis() - this.lastMS >= f) {
			return true;
		}
		return false;
	}
	
	public static long getCurrentMS() {
		return System.nanoTime() / 1000000L;
	}
	
	public void setLastMS(long lastMS) {
		this.lastMS = lastMS;
	}
	
	public int convertToMS(int perSecond) {
		return 1000 / perSecond;
	}
	
	public static boolean hasReached(long milli) {
		return getCurrentMS() - lastMS >= milli;
	}
	
	public static void reset() {
		lastMS = getCurrentMS();
	}
	
}
