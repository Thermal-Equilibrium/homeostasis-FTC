package com.ThermalEquilibrium.homeostasis.Parameters;

public class FeedforwardCoefficientsEx extends FeedforwardCoefficients{

	public double Kg;
	public double Kcos;

	/**
	 * General purpose feedforward
	 * @param Kv Velocity feedforward (from general motor model)
	 * @param Ka Acceleration feedforward (from general motor model)
	 * @param Ks Static friction feedforward (from general motor Model)
	 * @param Kg Gravity constant, for elevator / lift systems this is used to directly counter gravity.
	 * @param Kcos For rotating arm systems, this is multiplied by the Cos of the target angle to counter nonlinear effects.
	 */
	public FeedforwardCoefficientsEx(double Kv, double Ka, double Ks, double Kg, double Kcos) {
		super(Kv, Ka, Ks);
		this.Kg = Kg;
		this.Kcos = Kcos;
	}
}
