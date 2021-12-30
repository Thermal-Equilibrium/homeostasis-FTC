package com.ThermalEquilibrium.homeostasis.Controllers.Feedforward;


import com.ThermalEquilibrium.homeostasis.Parameters.FeedforwardCoefficients;

/**
 * Simple motor feedforward controller
 *
 * Ks = static friction feedforward
 * Kv = Velocity Feedforward
 * Ka = Acceleration Feedforward
 *
 */
public class BasicFeedforward implements FeedforwardController {


	protected FeedforwardCoefficients coefficients;

	public BasicFeedforward(FeedforwardCoefficients coefficients) {
		this.coefficients = coefficients;
	}

	@Override
	public double calculate(double x, double v, double a) {
		return v * coefficients.Kv + a * coefficients.Ka;
	}

}
