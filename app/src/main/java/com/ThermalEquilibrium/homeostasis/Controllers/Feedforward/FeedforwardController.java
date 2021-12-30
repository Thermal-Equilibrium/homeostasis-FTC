package com.ThermalEquilibrium.homeostasis.Controllers.Feedforward;

public interface FeedforwardController {
	/**
	 * Feedforward control output
	 * @param x target position
	 * @param v target velocity
	 * @param a target acceleration
	 * @return estimated motor command to reach that desired state.
	 */
	double calculate(double x, double v, double a);
}