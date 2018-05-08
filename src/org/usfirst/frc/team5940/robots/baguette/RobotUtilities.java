package org.usfirst.frc.team5940.robots.baguette;

public class RobotUtilities {
    
    public static double convertJoystickPositionToElevatorPosition(double joystickPosition) {
		double percentHeight = (joystickPosition + 1) / 2;
		return percentHeight * RobotConfig.MAX_ELEVATOR_HEIGHT;
	}

}
