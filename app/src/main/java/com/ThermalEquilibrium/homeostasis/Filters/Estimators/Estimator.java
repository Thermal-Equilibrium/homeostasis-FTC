package com.ThermalEquilibrium.homeostasis.Filters.Estimators;

import java.util.function.DoubleSupplier;

public abstract class Estimator {

	public DoubleSupplier measurement;

	/**
	 * Set up Double Supplier for recurring measurement obtainment.
	 * @param measurement measurement we want to obtain.
	 */
	public Estimator(DoubleSupplier measurement) {
		this.measurement = measurement;
	}

	/**
	 * Run estimation algorithm
	 * @return system state as determined by estimation algorithm.
	 */
	public abstract double update();

}
