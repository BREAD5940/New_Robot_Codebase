package org.usfirst.frc.team5940.robots.baguette;

import org.usfirst.frc.team5940.core.wpilib.PIDLoop;

public class ElevatorControlLoop {

	PIDLoop pidLoop = new PIDLoop(165, 0, 0);;
	int updateRate;

	public double update(double timeSinceLastUpdate, double targetPosition, double currentPosition) {
		double out = this.pidLoop.calculate(timeSinceLastUpdate, targetPosition, currentPosition);

		out = Math.min(12, Math.max(-12, out));
		return out;
	}
}
