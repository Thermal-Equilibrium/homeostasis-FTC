package com.ThermalEquilibrium.homeostasis.Utils;




public class MathUtils {

	public final static double TAU = Math.PI * 2;

	/**
	 * Makes sure an angle is in the range of -180 to 180
	 *
	 * @param angle angle we want to unwrap
	 * @return the corrected angle
	 */
	public static double AngleWrap(double angle){
		while (angle<-Math.PI){
			angle += 2.0* Math.PI;
		}
		while (angle> Math.PI){
			angle -= 2.0* Math.PI;
		}
		return angle;
	}

	/**
	 * Makes sure an angle is in the range of -180 to 180
	 * @param degrees angle we want to unwrap
	 * @return the corrected angle in degrees
	 */
	public static double AngleWrapDeg(double degrees) {
		while (degrees < -180) {
			degrees += 2.0 * 180;
		}
		while (degrees > 180) {
			degrees -= 2.0 * 180;
		}
		return degrees;
	}


	/**
	 * angle normalization from road runner
	 * @param radians the angle in radians we want to normalize
	 * @return the modified angle in radians
	 */
	public static double normalizeAngleRR(double radians) {
		double modifiedAngle = radians % TAU;
		modifiedAngle = (modifiedAngle + TAU) % TAU;
		return modifiedAngle;
	}


	/**
	 * sus thing that sometimes fixes imu data
	 * @param radians read angle in radians
	 * @return sus angle
	 */
	public static double normalizeAngle(double radians) {
		return AngleWrap(-normalizeAngleRR(radians));
	}


	/**
	 * calculates the normalized heading error from roadrunner odometry
	 * @param referenceRadians the angle we would like to be at
	 * @param stateRadians the angle where we are
	 * @return the normalized heading error in radians
	 */
	public static double normalizedHeadingError(double referenceRadians, double stateRadians) {

		return normalizeAngle(referenceRadians - stateRadians);
	}


	/**
	 * estimate second order integral
	 * @param value the current value we want to integrate
	 * @param lastValue the last value we integrated
	 * @param dt the delta time
	 * @return the integral estimate
	 */
	public static double approxSecondOrderIntegral(double value, double lastValue, double dt) {
		double sum = 0;
		sum += ((lastValue + value) / 2) * dt;
		return sum;
	}


	/**
	 * estimate first order integral
	 *
	 * @param value the value we would like to integrate
	 * @param dt    the delta time constant
	 * @return the instantaneous integration
	 */
	public static double approxFirstOrderIntegral(double value, double dt) {
		double sum;
		sum = value * dt;
		return sum;
	}


	/**
	 * sin c function, traditionally used for signal processing but produces a nice shape for
	 * scaling our differential drive controller to fix angle error.
	 * @param x value we want to calculate sin c for.
	 * @return sin_c of x.
	 */
	public static double sin_c(double x) {
		if (x == 0) return 1;
		try {
			return Math.sin(x) / x;
		} catch (ArithmeticException e) {
			return 1;
		}
	}
}
