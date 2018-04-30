package org.usfirst.frc.team5940.pantry.wpilib;

public enum MotorType {
	CIM(0, 0, 0, 0), MiniCIM(0, 0, 0, 0), PRO(0.71, 134, 18730, 0.7);

	private final double stallTorque;
	private final double stallCurrent;
	private final double freeSpeed;
	private final double freeCurrent;

	MotorType(double stallTorque, double stallCurrent, double freeSpeed, double freeCurrent) {
		this.stallCurrent = stallCurrent;
		this.stallTorque = stallTorque;
		this.freeCurrent = freeCurrent;
		this.freeSpeed = freeSpeed;
	}

	public double getFreeCurrent() {
		return freeCurrent;
	}

	public double getFreeSpeed() {
		return freeSpeed;
	}

	public double getStallCurrent() {
		return stallCurrent;
	}

	public double getStallTorque() {
		return stallTorque;
	}
}