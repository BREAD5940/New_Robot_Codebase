package org.usfirst.frc.team5940.pantry.wpilib;

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
	 * This should only be updated once every update if you are using kI or kD. This
	 * must be updated at least once every cycle if kI and kD are being used.
	 * 
	 * @param updateRate
	 *            The updateRate of the control loop in seconds.
	 * @param target
	 *            The target.
	 * @param position
	 *            The current position of the item.
	 * @return The value of the PIDLoop
	 */
	public double calculate(double updateRate, double target, double position) {
		double deltaTime = updateRate;

		double error = (target - position) * deltaTime;
		double deltaError = error - this.previousError;
		this.totalError += error;

		double out = this.kP * error + this.kI * this.totalError + this.kD * deltaError;
		this.previousError = error;
		return out;
	}

}
