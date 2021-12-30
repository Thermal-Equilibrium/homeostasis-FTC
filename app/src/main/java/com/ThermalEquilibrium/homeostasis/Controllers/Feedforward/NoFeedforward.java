package com.ThermalEquilibrium.homeostasis.Controllers.Feedforward;


/**
 * Used to clarify that you will not be using feedforward control.
 */
public class NoFeedforward implements FeedforwardController{
	@Override
	public double calculate(double x, double v, double a) {
		return 0;
	}
}
