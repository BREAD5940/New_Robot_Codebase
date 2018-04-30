package org.usfirst.frc.team5940.robot;

public class ElevatorJoystickTarget {

	public double getTarget(double joystickPosition) {
		double percentHeight = (joystickPosition + 1) / 2;
		return percentHeight * RobotConfig.MAX_ELEVATOR_HEIGHT;
	}
}
