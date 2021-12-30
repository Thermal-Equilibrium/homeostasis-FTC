package com.ThermalEquilibrium.homeostasis.Parameters;

public class PIDCoefficientsEx extends PIDCoefficients{
	public double maximumIntegralSum;
	public double stabilityThreshold;
	public double lowPassGain;

	/**
	 * @param Kp proportional term
	 * @param Ki integral term
	 * @param Kd derivative term
	 * @param maximumIntegralSum the maximum our integral sum can go to
*                              (this * Kp should be less than the maximum output of your system)
	 * @param stabilityThreshold the maximum our derivative can be before we integrate.
*                           This ensures we have better stability
	 */
	public PIDCoefficientsEx(double Kp, double Ki, double Kd,
							 double maximumIntegralSum,
							 double stabilityThreshold,
							 double lowPassGain) {
		super(Kp, Ki, Kd);
		this.maximumIntegralSum = maximumIntegralSum;
		this.stabilityThreshold = stabilityThreshold;
		this.lowPassGain = lowPassGain;
	}
}
