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

	public double calculate(double timeSinceLastUpdate, double currentPosition, double targetPosition) {
		double error = targetPosition - currentPosition;
		
		totalError += error;
		
		double deltaPosition = currentPosition - previousPosition;

		this.previousPosition = currentPosition;
		return (totalError * this.kI + error * this.kP + deltaPosition * this.kD) * timeSinceLastUpdate;
	}

}
