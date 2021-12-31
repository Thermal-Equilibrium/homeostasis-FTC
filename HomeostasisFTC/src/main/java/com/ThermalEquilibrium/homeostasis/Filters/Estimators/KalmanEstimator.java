package com.ThermalEquilibrium.homeostasis.Filters.Estimators;



import android.os.Build;

import com.ThermalEquilibrium.homeostasis.Filters.FilterAlgorithms.KalmanFilter;

import java.util.function.DoubleSupplier;

/**
 * Using a custom Least Squares Regression + Kalman Filter combination we can accurately reject noise
 * from our signal while attempting to minimize phase lag.
 */
public class KalmanEstimator extends Estimator{

	protected KalmanFilter kalmanFilter;

	/**
	 * @param Q Sensor Covariance
	 * @param R Model Covariance
	 * @param N Number of elements we can hold in our stack.
	 */
	public KalmanEstimator(DoubleSupplier measurement, double Q, double R, int N) {
		super(measurement);
		kalmanFilter = new KalmanFilter(Q,R,N);
	}

	@Override
	public double update() {
		return kalmanFilter.estimate(measurement.getAsDouble());
	}
}
