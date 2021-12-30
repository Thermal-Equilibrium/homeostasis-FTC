package com.ThermalEquilibrium.homeostasis.Parameters;

public class BangBangParameters {
	public double maxOutput;
	public double hysteresis;

	/**
	 * Nonlinear controller that makes use of an if statement to generate the control output.
	 *
	 * Not recommended for the majority of use cases.
	 *
	 * @param maxOutput the maximum output power
	 * @param hysteresis the range around 0 error that we don't want the controller to react to.
	 * 						Larger range will decrease oscillations but increase steady state error.
	 */
	public BangBangParameters(double maxOutput, double hysteresis) {
		this.maxOutput = maxOutput;
		this.hysteresis = hysteresis;
	}
}
