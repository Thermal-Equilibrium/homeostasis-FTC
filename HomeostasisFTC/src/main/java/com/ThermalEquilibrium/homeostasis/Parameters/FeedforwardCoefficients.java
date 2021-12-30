package com.ThermalEquilibrium.homeostasis.Parameters;

public class FeedforwardCoefficients {

	public double Kv;
	public double Ka;
	public double Ks;

	/**
	 * Basic motor feedforward
	 * @param Kv Velocity feedforward
	 * @param Ka Acceleration feedforward
	 * @param Ks static friction compensation
	 */
	public FeedforwardCoefficients(double Kv, double Ka, double Ks) {
		this.Kv = Kv;
		this.Ka = Ka;
		this.Ks = Ks;
	}
}
