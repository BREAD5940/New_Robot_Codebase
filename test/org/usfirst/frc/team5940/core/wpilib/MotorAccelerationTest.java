package org.usfirst.frc.team5940.core.wpilib;

public class MotorAccelerationTest {

	double kt;
	double gearRatio;
	double kv;
	double motorResistance;
	double sprocketRadius;
	double effectiveMass;

	public MotorAccelerationTest(MotorType motorType, double motorCount, double gearRatio, double pulleyRadius,
			double mass) throws IllegalArgumentException, IllegalStateException {
		this.kt = (motorCount * motorType.getStallTorque()) / motorType.getStallCurrent();
		this.gearRatio = gearRatio;
		this.motorResistance = 12 / motorType.getStallCurrent();
		this.kv = (((motorType.getFreeSpeed() / 60.0) * 2.0 * Math.PI)
				/ (12.0 - motorResistance * motorType.getFreeCurrent()));
		this.effectiveMass = mass;
		this.sprocketRadius = pulleyRadius;
	}

	public double calculateAcceleration(double setVolts, double currentVelocity) {
		return -kt * gearRatio * gearRatio / (kv * motorResistance * sprocketRadius * sprocketRadius * effectiveMass)
				* currentVelocity + gearRatio * kt / (motorResistance * sprocketRadius * effectiveMass) * setVolts;
	}

}
