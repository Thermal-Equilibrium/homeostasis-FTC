package com.ThermalEquilibrium.homeostasis.Parameters;

public class PIDCoefficients {

	public double Kp;
	public double Ki;
	public double Kd;

	/**
	 * Standard PID coefficients
	 * @param Kp proportional term, multiplied directly by the state error
	 * @param Ki integral term, multiplied directly by the state error integral
	 * @param Kd derivative term, multiplied directly by the state error rate of change.
	 */
	public PIDCoefficients(double Kp, double Ki, double Kd) {
		this.Kp = Kp;
		this.Ki = Ki;
		this.Kd = Kd;
	}

}
