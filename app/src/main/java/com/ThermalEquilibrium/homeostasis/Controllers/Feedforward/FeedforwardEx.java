package com.ThermalEquilibrium.homeostasis.Controllers.Feedforward;


import com.ThermalEquilibrium.homeostasis.Parameters.FeedforwardCoefficientsEx;

/**
 * Generalized Feedforward for FTC
 *
 * Includes all of BasicFeedforward as well as feedforwards for gravity compensation and
 * a specific K cos feedforward for angle control.
 *
 */
public class FeedforwardEx extends BasicFeedforward {

	 protected FeedforwardCoefficientsEx coefficients;

	public FeedforwardEx(FeedforwardCoefficientsEx coefficients) {

		super(coefficients);
		this.coefficients = coefficients;
	}

	@Override
	public double calculate(double x, double v, double a) {
		return v * coefficients.Kv + a * coefficients.Ka + Math.cos(x) * coefficients.Kcos + coefficients.Kg;
	}


}
