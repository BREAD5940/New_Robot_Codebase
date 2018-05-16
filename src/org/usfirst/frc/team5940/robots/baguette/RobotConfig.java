package org.usfirst.frc.team5940.robots.baguette;

import org.usfirst.frc.team5940.core.controller_layout.XBoxControllerLayout;
import org.usfirst.frc.team5940.core.wpilib.MotorType;

public interface RobotConfig {

	public static final boolean TESTING_MODE = false;

	// JOYSTICK CONFIGURATION
	public static final int INTAKE_CLAMP_BUTTON = 1;

	public static final int INTAKE_UNCLAMP_BUTTON = 2;

	public static final int INTAKE_CONTROL_FORWARD_AXIS = 1;

	public static final int INTAKE_CONTROL_YAW_AXIS = 0;

	public static final int ELEVATOR_CONTROL_AXIS = 2;

	public static final int DRIVETRAIN_YAW_AXIS = XBoxControllerLayout.Axis.RIGHT_JOYSTICK_X;

	public static final int DRIVETRAIN_FORWARD_AXIS = XBoxControllerLayout.Axis.LEFT_JOYSTICK_Y;

	public static final double DRIVETRAIN_YAW_AXIS_DEADZONE = 0;

	public static final double DRIVETRAIN_FORWARD_AXIS_DEADZONE = 0;

	public static final int SHIFT_UP_BUTTON = XBoxControllerLayout.Buttons.RB_BUTTON;

	public static final int SHIFT_DOWN_BUTTON = XBoxControllerLayout.Buttons.LB_BUTTON;

	// AXIS INVERSION
	public static final boolean DRIVETRAIN_FORWARD_AXIS_INVERTED = true;

	public static final boolean DRIVETRAIN_YAW_AXIS_INVERTED = false;

	public static final boolean CUBE_INTAKE_YAW_AXIS_INVERTED = false;

	public static final boolean CUBE_INTAKE_FORWARD_AXIS_INVERTED = true;

	public static final boolean ELEVATOR_AXIS_INVERTED = true;

	// ELEVATOR SPEED SCALING
	public static final double MAX_ELEVATOR_HEIGHT_MAX_SPEED = 0.32;

	public static final double INITIAL_SPEED_SCALING_PERCENT_HEIGHT = 0.36;

	// INTAKE SENSORS
	public static final boolean INTAKE_SENSORS_INVERTED = true;

	public static final int RIGHT_INTAKE_SENSOR_DIGITAL_INPUT_PORT = 0;

	public static final int LEFT_INTAKE_SENSOR_DIGITAL_INPUT_PORT = 1;

	// I did something odd below so people don't accidently change the wrong value.
	// This should work.
	// REQUIRES UPDATE
	public static final boolean INTAKE_TALONS_REQUIRE_UPDATE = TESTING_MODE ? !TESTING_MODE : true;

	public static final boolean INTAKE_PNEUMATICS_REQUIRE_UPDATE = TESTING_MODE ? !TESTING_MODE : true;

	public static final boolean ELEVATOR_TALON_REQUIRE_UPDATE = TESTING_MODE ? !TESTING_MODE : true;

	public static final boolean DRIVETRAIN_TALONS_REQUIRE_UPDATE = TESTING_MODE ? !TESTING_MODE : true;

	public static final boolean DRIVETRAIN_SHIFTING_REQUIRE_UPDATE = TESTING_MODE ? !TESTING_MODE : true;

	// I did something odd below so people don't accidently change the wrong value.
	// This should work.
	// REQUIRES UPDATE
	public static final boolean LEFT_INTAKE_TALON_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : false;

	public static final boolean RIGHT_INTAKE_TALON_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : false;

	public static final boolean INTAKE_PNEUMATICS_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : true;

	public static final boolean ELEVATOR_TALON_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : true;

	public static final boolean LEFT_DRIVETRAIN_TALONS_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE
			: true;

	public static final boolean RIGHT_DRIVETRAIN_TALONS_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE
			: true;

	public static final boolean DRIVETRAIN_SHIFTING_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : false;

	public static final boolean DRIVETRAIN_CONTROLMODE_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE
			: false;

	public static final boolean RIGHT_ENCODER_POSITION_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE
			: true;

	public static final boolean ELEVATOR_CURRENT_HEIGHT_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE
			: true;

	public static final boolean AUTO_PATH_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : true;

	public static final boolean CURRENT_ACTION_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : true;

	public static final boolean ROBOT_ANGLE_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : true;

	public static final boolean CUBE_INTAKED_SMARTDASHBOARD_REQUIRE_UPDATE = TESTING_MODE ? TESTING_MODE : true;

	// TALON PORTS
	public static final int SLAVE_LEFT_TALON_PORT = 1;

	public static final int MASTER_LEFT_TALON_PORT = 2;

	public static final int SLAVE_RIGHT_TALON_PORT = 3;

	public static final int MASTER_RIGHT_TALON_PORT = 4;

	public static final int MASTER_ELEVATOR_TALON_PORT = 5;

	public static final int LEFT_INTAKE_TALON_PORT = 6;

	public static final int RIGHT_INTAKE_TALON_PORT = 7;

	// ELEVATOR
	public static final double MAX_ELEVATOR_HEIGHT = 0.8; // 84.5 / 12;

	public static final double ELEVATOR_SPROCKET_RADIUS = 0.0162;

	public static final double MAX_ELEVATOR_VOLTS = 12;

	public static final int ELEVATOR_MOTOR_COUNT = 2;

	public static final int ELEVATOR_GEAR_RATIO = 30;

	public static final double ELEVATOR_MASS = 28.18;

	public static final MotorType ELEVATOR_MOTOR_TYPE = MotorType.PRO;

	// ELEVATOR PID
	public static final double ELEVATOR_TALON_P = 165;
	
	public static final double ELEVATOR_TALON_D = 0;

	// INTAKE
	public static final int INTAKE_SOLENOID_FORWARD_CHANNEL = 0;

	public static final int INTAKE_SOLENOID_REVERSE_CHANNEL = 6;

	// DRIVETRAIN
	public static final int DRIVETRAIN_SOLENOID_SHIFTING_FORWARD_CHANNEL = 7;

	public static final int DRIVETRAIN_SOLENOID_SHIFTING_REVERSE_CHANNEL = 3;

	// TODO change to meters. 
	public static final float WHEEL_DIAMETER = 6f / 12;

	// GENERAL
	public static final double VELOCITY_PULSES_PER_ROTATION = 409.6f;

	public static final double POSITION_PULSES_PER_ROTATION = 4096f;

	public static final int SOLENOID_MODULE_NUMBER = 9;
	
	public static final double UPDATE_RATE = 0.02;

	// CIABATTA
	public static final float CIABATTA_LOW_GEAR_POSITION_P = 0.5f;

	public static final float CIABATTA_LOW_GEAR_POSITION_I = 0f;

	public static final float CIABATTA_LOW_GEAR_POSITION_D = 20f;

	public static final float CIABATTA_LOW_GEAR_POSITION_F = 0f;

	public static final float CIABATTA_LOW_GEAR_VELOCITY_P = 0.9f;

	public static final float CIABATTA_LOW_GEAR_VELOCITY_I = 0.0025f;

	public static final float CIABATTA_LOW_GEAR_VELOCITY_D = 40f;

	public static final float CIABATTA_LOW_GEAR_VELOCITY_F = 0.15f;
}
