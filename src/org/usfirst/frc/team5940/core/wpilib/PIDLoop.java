package org.usfirst.frc.team5940.core.wpilib;

public class PIDLoop {

	double kP;
	double kI;
	double kD;
	double previousError;
	double totalError;

	/**
	 * Creates a new PID loop calculator
	 * 
	 * @param kP
	 *            p constant
	 * @param kI
	 *            i constant
	 * @param kD
	 *            d constant
	 */
	public PIDLoop(double kP, double kI, double kD) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
	}

	/**
	 * This calculates the new values for the PIDLoop and returns the value of the
	 * PID loop. The timeSinceLastUpdated should be accurate within about a
	 * millisecond, but doesn't have to be exact.
	 * 
	 * @param timeSinceLastUpdate
	 *            The time since the last time the calcualte method was run in
	 *            seconds. If this is run once per cycle then this should be the
	 *            cycle time.
	 * @param target
	 *            The target.
	 * @param current
	 *            The current position of the item.
	 * @return The value of the PIDLoop
	 */
	public double calculate(double timeSinceLastUpdate, double target, double current) {

		double error = (target - current) * timeSinceLastUpdate;
		double deltaError = error - this.previousError;
		this.totalError += error;

		double out = this.kP * error + this.kI * this.totalError + this.kD * deltaError;
		this.previousError = error;
		return out;
	}

}
