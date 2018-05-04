package org.usfirst.frc.team5940.robots.baguette;

public class ElevatorJoystickTarget {

	//THIS CLASS IS DEPRECATED AND NOT IN USE

	public double getTarget(double joystickPosition) {
		double percentHeight = (joystickPosition + 1) / 2;
		return percentHeight * RobotConfig.MAX_ELEVATOR_HEIGHT;
	}
}


