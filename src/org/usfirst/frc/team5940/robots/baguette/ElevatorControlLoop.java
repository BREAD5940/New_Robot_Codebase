package org.usfirst.frc.team5940.robots.baguette;

import org.usfirst.frc.team5940.core.wpilib.PIDLoop;

public class ElevatorControlLoop {

	PIDLoop pidLoop;
	double updateRate;

	public ElevatorControlLoop(double updateRate) {
		pidLoop = new PIDLoop(165, 0, 0);
		this.updateRate = updateRate;
	}

	public double update(double targetPosition, double currentPosition) {
		double out = this.pidLoop.calculate(this.updateRate, targetPosition, currentPosition);

		out = Math.min(12, Math.max(-12, out));
		return out;
	}
}
