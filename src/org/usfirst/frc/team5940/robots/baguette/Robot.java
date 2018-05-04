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
		this.elevatorJoystickTarget = new ElevatorJoystickTarget();
	}

	@Override
	public void teleopPeriodic() {

		double currentPosition = RobotUtilities.convertEncoderValueToUnit(RobotConfig.POSITION_PULSES_PER_ROTATION, RobotConfig.ELEVATOR_SPROCKET_RADIUS, elevatorTalon.getSelectedSensorPosition(0));

		double joystickPosition = operatorJoystick.getRawAxis(RobotConfig.ELEVATOR_CONTROL_AXIS);

		double adjustedJoystickPosition = Utilities.InvertAxisIfNeeded(RobotConfig.ELEVATOR_AXIS_INVERTED, joystickPosition);

		// TODO also make static method. In robot specific utilities though.
		double targetPosition = this.elevatorJoystickTarget.getTarget(adjustedJoystickPosition);

		double setVolts = this.elevatorControlLoop.update(targetPosition, currentPosition);

		this.elevatorTalon.set(ControlMode.PercentOutput, setVolts / 12);
	}
}
