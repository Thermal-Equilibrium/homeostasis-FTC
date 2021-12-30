package com.ThermalEquilibrium.homeostasis.Utils;


/**
 * This should really just be the FTC elapsed timer but I made my own due to annoying reasons
 */
public class Timer {

	public double previousTime;

	public Timer() {
		this.previousTime = sysTimeSeconds();
	}


	/**
	 *
	 * @return current elapsed time in seconds.
	 */
	public double currentTime() {
		return sysTimeSeconds() - previousTime;
	}

	/**
	 * reset the timer
	 */
	public void reset() {
		this.previousTime = currentTime();
	}

	/**
	 * get the current system time in seconds
	 * @return current system time in seconds
	 */
	protected double sysTimeSeconds() {
		return System.currentTimeMillis() / 1000.0;
	}



}
