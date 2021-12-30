package com.ThermalEquilibrium.homeostasis.Systems;


import com.ThermalEquilibrium.homeostasis.Controllers.Feedback.FeedbackController;
import com.ThermalEquilibrium.homeostasis.Controllers.Feedforward.FeedforwardController;
import com.ThermalEquilibrium.homeostasis.Filters.Estimators.Estimator;

/**
 * A simple control system that consists of an estimator, a feedback, and a feedforward controller.
 */
public class BasicSystem {

	public Estimator estimator;
	public FeedbackController feedbackController;
	public FeedforwardController feedforwardController;

	public BasicSystem(Estimator estimator, FeedbackController feedbackController,
					   FeedforwardController feedforwardController) {
		this.estimator = estimator;
		this.feedbackController = feedbackController;
		this.feedforwardController = feedforwardController;
	}

	public BasicSystem(Estimator estimator, FeedbackController feedbackController) {
		this.feedforwardController = null;
		this.estimator = estimator;
		this.feedbackController = feedbackController;
	}

	public BasicSystem(Estimator estimator, FeedforwardController feedforwardController) {
		this.estimator = estimator;
		this.feedforwardController = feedforwardController;
	}

	/**
	 * position only control
	 * @param x position control
	 * @return position control output
	 */
	public double update(double x) {
		return update(x,0,0);
	}

	/**
	 * position velocity control
	 * @param x position control
	 * @param v velocity control
	 * @return position, velocity control
	 */
	public double update(double x, double v) {
		return update(x,v,0);
	}

	public double update(double x, double v, double a) {
		double estimate = estimator.update();
		double output = 0;
		if (feedforwardController != null) {
			output += feedforwardController.calculate(x,v,a);
		}
		if (feedbackController != null) {
			output += feedbackController.calculate(x,estimate);
		}
		return output;
	}

}
