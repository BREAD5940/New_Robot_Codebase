package org.usfirst.frc.team5940.core.wpilib;

public class PID {

	double kP;
	double kI;
	double kD;

	double totalError = 0;

	double previousPosition;

	public PID(double kP, double kI, double kD) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
	}

	// TODO make the update rate constant. This also might not work on the first
	// update if the starting position != 0.
	public double calculate(double timeSinceLastUpdate, double targetPosition, double currentPosition) {
		double error = targetPosition - currentPosition;
		totalError += error * timeSinceLastUpdate;

		double deltaPosition = (currentPosition - previousPosition) / timeSinceLastUpdate;

		this.previousPosition = currentPosition;
		return totalError * this.kI + error * this.kP + deltaPosition * this.kD;
	}

}
