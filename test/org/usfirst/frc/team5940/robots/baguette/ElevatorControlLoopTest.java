package org.usfirst.frc.team5940.robots.baguette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.usfirst.frc.team5940.core.wpilib.MotorAccelerationTest;
import org.usfirst.frc.team5940.robots.baguette.ElevatorPIDLoop;

@RunWith(Parameterized.class)
public class ElevatorControlLoopTest {

	@Parameters
	public static Collection testValues() {
		return Arrays.asList(new Object[][] { { 1, 0, 2 }, { 0, 0, 20 }, { 0, 0.6, 2 } });
	}

	@Parameter
	public double targetPosition;

	@Parameter(1)
	public double startingPosition;

	@Parameter(2)
	public double testDuration;
		
	@Test
	public void testElevatorMovement() {
		MotorAccelerationTest elevatorAccelerationCalculator = new MotorAccelerationTest(
				RobotConfig.ELEVATOR_MOTOR_TYPE, RobotConfig.ELEVATOR_MOTOR_COUNT, RobotConfig.ELEVATOR_GEAR_RATIO,
				RobotConfig.ELEVATOR_SPROCKET_RADIUS, RobotConfig.ELEVATOR_MASS);
		ElevatorPIDLoop testLoop = new ElevatorPIDLoop();

		final double dt = 0.001;
		final double updateRate = RobotConfig.UPDATE_RATE;
		final long controlLoopUpdateRate = Math.round(updateRate / dt);

		double currentPosition = startingPosition;
		int currentUpdate = 0;
		double setVolts = 0;
		double currentVelocity = 0;
		for (double currentTime = 0; currentTime <= testDuration; currentTime += dt) {
			if (currentUpdate % controlLoopUpdateRate == 0) {
				setVolts = testLoop.update(updateRate, targetPosition, currentPosition);
				assertTrue(setVolts <= 12);
				assertTrue(setVolts >= -12);

			}
			currentUpdate++;

			double motorAcceleration = elevatorAccelerationCalculator.calculateAcceleration(setVolts, currentVelocity);
			double gravityAdjustedAcceleration = motorAcceleration - 9.8;
			currentVelocity += dt * gravityAdjustedAcceleration;

			currentPosition += dt * currentVelocity;

			assertTrue(currentPosition >= -0.03);
			assertTrue(currentPosition <= RobotConfig.MAX_ELEVATOR_HEIGHT + 0.03);
		}

		double filteredTarget = Math.min(RobotConfig.MAX_ELEVATOR_HEIGHT, Math.max(0, targetPosition));

		assertEquals(filteredTarget, currentPosition, 0.02);
	}
}
