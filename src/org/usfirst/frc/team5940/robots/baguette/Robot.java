package org.usfirst.frc.team5940.robots.baguette;

import org.usfirst.frc.team5940.core.wpilib.EncoderConversion;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

	TalonSRX elevatorTalon = new TalonSRX(RobotConfig.MASTER_ELEVATOR_TALON_PORT);

	Joystick operatorJoystick = new Joystick(1);

	ElevatorControlLoop elevatorControlLoop;
	ElevatorJoystickTarget elevatorJoystickTarget;
	EncoderConversion elevatorPositionConversion;

	@Override
	public void robotInit() {
		this.elevatorControlLoop = new ElevatorControlLoop(this.getPeriod());
		this.elevatorJoystickTarget = new ElevatorJoystickTarget();
		this.elevatorPositionConversion = new EncoderConversion(RobotConfig.POSITION_PULSES_PER_ROTATION,
				RobotConfig.ELEVATOR_SPROCKET_RADIUS);
	}

	@Override
	public void teleopPeriodic() {
		double currentPosition = elevatorPositionConversion.convert(elevatorTalon.getSelectedSensorPosition(0));

		double joystickPosition = operatorJoystick.getRawAxis(RobotConfig.ELEVATOR_CONTROL_AXIS);

		double adjustedJoystickPosition = (RobotConfig.ELEVATOR_AXIS_INVERTED) ? -joystickPosition : joystickPosition;

		double targetPosition = this.elevatorJoystickTarget.getTarget(adjustedJoystickPosition);

		double setVolts = this.elevatorControlLoop.update(targetPosition, currentPosition);

		this.elevatorTalon.set(ControlMode.PercentOutput, setVolts / 12);//
	}
}
