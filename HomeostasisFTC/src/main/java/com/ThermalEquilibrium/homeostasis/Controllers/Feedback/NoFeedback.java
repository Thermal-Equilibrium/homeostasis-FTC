package com.ThermalEquilibrium.homeostasis.Controllers.Feedback;

/**
 * Used for whenever you need to clarify that you will not be using feedback control.
 */
public class NoFeedback implements FeedbackController{
	@Override
	public double calculate(double reference, double state) {
		return 0;
	}
}
