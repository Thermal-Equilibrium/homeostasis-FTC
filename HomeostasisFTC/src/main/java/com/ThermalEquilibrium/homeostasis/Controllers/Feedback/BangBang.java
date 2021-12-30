package com.ThermalEquilibrium.homeostasis.Controllers.Feedback;


import com.ThermalEquilibrium.homeostasis.Parameters.BangBangParameters;

public class BangBang implements FeedbackController {

	protected BangBangParameters parameters;

	public BangBang(BangBangParameters parameters) {
		this.parameters = parameters;
	}

	@Override
	public double calculate(double reference, double state) {
		double error = calculateError(reference, state);
		if (Math.abs(error) < parameters.hysteresis) return 0;
		if (error > 0) return parameters.maxOutput;
		if (error < 0) return -parameters.maxOutput;
		return 0;
	}

	protected double calculateError(double reference, double state) {
		return reference - state;
	}

}
