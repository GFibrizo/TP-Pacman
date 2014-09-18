package com.grupo2.constants;

/**
 *
 * @author fibrizo
 */
public final class Constants {

	private static long TICK_TO_MILISECS = 1000;

	private static float PREY_LIMIT_TIME = 30;
	private static float DEAD_LIMIT_TIME = 20;

	private static float FIRST_RAGE_LIMIT_TIME = 5;
	private static float SECOND_RAGE_LIMIT_TIME = 10;
	private static float THIRD_RAGE_LIMIT_TIME = 15;

	private static float GHOST_RADIUS = 2;

	private Constants() {
		//this prevents even the native class from
		//calling this ctor as well :
		throw new AssertionError();
	}

	public static float getPreyLimitTime() {
		return PREY_LIMIT_TIME;
	}

	public static float getDeadLimitTime() {
		return DEAD_LIMIT_TIME;
	}

	public static float getFirstRageLimitTime() {
		return FIRST_RAGE_LIMIT_TIME;
	}

	public static float getSecondRageLimitTime() {
		return SECOND_RAGE_LIMIT_TIME;
	}

	public static float getThirdRageLimitTime() {
		return THIRD_RAGE_LIMIT_TIME;
	}

	public static float getGhostRadius() {
		return GHOST_RADIUS;
	}

	public static long getTickToMilisecs() {
		return TICK_TO_MILISECS;
	}

	public static void setPreyLimitTime(float timeLimit) {
		Constants.PREY_LIMIT_TIME = timeLimit;
	}

	public static void setDeadLimitTime(float timeLimit) {
		Constants.DEAD_LIMIT_TIME = timeLimit;
	}

	public static void setFirstRageLimitTime(float timeLimit) {
		Constants.FIRST_RAGE_LIMIT_TIME = timeLimit;
	}

	public static void setSecondRageLimitTime(float timeLimit) {
		Constants.SECOND_RAGE_LIMIT_TIME = timeLimit;
	}

	public static void setThirdRageLimitTime(float timeLimit) {
		Constants.THIRD_RAGE_LIMIT_TIME = timeLimit;
	}

	public static void setGhostRadius(float radius) {
		Constants.GHOST_RADIUS = radius;
	}

	public static void setTickToMilisecs(long ticks) {
		Constants.TICK_TO_MILISECS = ticks;
	}

}
