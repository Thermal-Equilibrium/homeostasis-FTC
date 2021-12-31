package com.ThermalEquilibrium.homeostasis.Filters.Estimators;


import java.util.function.DoubleSupplier;


/**
 * When you have good sensors.
 */
public class RawValue extends Estimator {
	/**
	 * Set up Double Supplier for recurring measurement obtainment.
	 *
	 * @param measurement measurement we want to obtain.
	 */
	public RawValue(DoubleSupplier measurement) {
		super(measurement);
	}

	@Override
	public double update() {
		return measurement.getAsDouble();
	}
}
