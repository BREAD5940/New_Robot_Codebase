package org.usfirst.frc.team5940.robots.baguette;

import org.usfirst.frc.team5940.core.wpilib.PID;

public class ElevatorPIDLoop {

	PID pidLoop = new PID(165, 0, 0);

	public double update(double timeSinceLastUpdate, double targetPosition, double currentPosition) {
		targetPosition = Math.min(RobotConfig.MAX_ELEVATOR_HEIGHT, Math.max(0, targetPosition));
		double out = this.pidLoop.calculate(timeSinceLastUpdate, targetPosition, currentPosition);
		out = Math.min(12, Math.max(-12, out));
		return out;
	}
}
