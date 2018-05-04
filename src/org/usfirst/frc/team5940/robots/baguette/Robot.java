package org.usfirst.frc.team5940.robots.baguette;

import org.usfirst.frc.team5940.core.wpilib.EncoderConversion;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import org.usfirst.frc.team5940.core.main.Utilities;
import org.usfirst.frc.team5940.robots.baguette.RobotUtilities;

public class Robot extends TimedRobot {

	TalonSRX elevatorTalon = new TalonSRX(RobotConfig.MASTER_ELEVATOR_TALON_PORT);

	Joystick operatorJoystick = new Joystick(1);

	ElevatorControlLoop elevatorControlLoop;
	ElevatorJoystickTarget elevatorJoystickTarget;

	@Override
	public void robotInit() {
		this.elevatorControlLoop = new ElevatorControlLoop(this.getPeriod());
	}

	@Override
	public void teleopPeriodic() {
		elevatorLoop();
	}

	public void elevatorLoop(){

		//Get current position from the encoder and convert it to a usable unit
		double currentPosition = Utilities.convertEncoderValueToUnit(RobotConfig.POSITION_PULSES_PER_ROTATION, RobotConfig.ELEVATOR_SPROCKET_RADIUS, elevatorTalon.getSelectedSensorPosition(0));

		//Get the joystick position, invert it if needed, and then calculate the elevator target position correlating to the joystick position
		double joystickPosition = operatorJoystick.getRawAxis(RobotConfig.ELEVATOR_CONTROL_AXIS);
		double adjustedJoystickPosition = Utilities.InvertAxisIfNeeded(RobotConfig.ELEVATOR_AXIS_INVERTED, joystickPosition);
		double targetPosition = RobotUtilities.convertJoystickPositionToElevatorPosition(adjustedJoystickPosition);

		// Calculate voltage required based on current and target position and set talon to it
		double setVolts = this.elevatorControlLoop.update(targetPosition, currentPosition);
		this.elevatorTalon.set(ControlMode.PercentOutput, setVolts / 12);
		
	}
}
