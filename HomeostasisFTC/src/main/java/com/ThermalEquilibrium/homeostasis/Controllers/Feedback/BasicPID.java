package com.ThermalEquilibrium.homeostasis.Controllers.Feedback;


import com.ThermalEquilibrium.homeostasis.Parameters.PIDCoefficients;
import com.ThermalEquilibrium.homeostasis.Utils.Timer;

public class BasicPID implements FeedbackController {

	PIDCoefficients coefficients;

	protected boolean hasRun = false;

	protected Timer timer = new Timer();

	protected double previousError = 0;

	protected double integralSum = 0;

	protected double derivative = 0;

	public BasicPID(PIDCoefficients coefficients) {
		this.coefficients = coefficients;
	}

	/**
	 * calculate PID output
	 * @param reference the target position
	 * @param state current system state
	 * @return PID output
	 */
	@Override
	public double calculate(double reference, double state) {
		double dt = getDT();
		double error = calculateError(reference, state);
		double derivative = calculateDerivative(error,dt);
		integrate(error,dt);
		previousError = error;
		return error * coefficients.Kp
					 + integralSum * coefficients.Ki
					 + derivative * coefficients.Kd;
	}

	/**
	 * get the time constant
	 * @return time constant
	 */
	public double getDT() {
		if (!hasRun) {
			hasRun = true;
			timer.reset();
		}
		double dt = timer.currentTime();
		timer.reset();
		return dt;
	}

	protected double calculateError(double reference, double state) {
		return reference - state;
	}

	protected void integrate(double error, double dt) {
		integralSum += ((error + previousError) / 2) * dt;
	}

	protected double calculateDerivative(double error, double dt) {
		derivative = (error - previousError) / dt;
		return derivative;
	}

}
