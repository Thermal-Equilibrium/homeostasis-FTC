package com.ThermalEquilibrium.homeostasis.Controllers.Feedback;


import com.ThermalEquilibrium.homeostasis.Utils.Vector;

public class FullStateFeedback {

	protected Vector K;

	/**
	 * controller gains
	 * @param K Gain Vector K
	 */
	public FullStateFeedback(Vector K) {
		this.K = K;
	}

	public double calculate(Vector reference, Vector State) throws Exception {
		return reference.minus(State).dot(K);
	}



}
