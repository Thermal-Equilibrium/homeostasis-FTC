package com.ThermalEquilibrium.homeostasis.Controllers.Feedback;

import static com.ThermalEquilibrium.homeostasis.Utils.MathUtils.normalizedHeadingError;

/**
 * feedback controller that converts the inputs of another controller to work with angles.
 */
public class AngleController implements FeedbackController {

	FeedbackController controller;

	/**
	 * This controller converts radian degrees to work properly with another linear controller
	 * @param controller the feedback controller we would like to use.
	 */
	public AngleController(FeedbackController controller) {
		this.controller = controller;
	}


	/**
	 * calculate the feedback controller output using angle measurements and references
	 * @param reference the angle (in radians) we would like to reach
	 * @param state the current angle (in radians) that the system is in.
	 * @return feedback output
	 */
	@Override
	public double calculate(double reference, double state) {
		double error = normalizedHeadingError(reference, state);
		return controller.calculate(0, error);
	}
}
