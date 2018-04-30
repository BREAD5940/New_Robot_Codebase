package org.usfirst.frc.team5940.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ElevatorJoystickTargetTest {

	ElevatorJoystickTarget target = new ElevatorJoystickTarget();

	@Test
	public void zeroHeight() {
		assertEquals(0, target.getTarget(-1), 0);
	}

	@Test
	public void middleHeight() {
		assertEquals(RobotConfig.MAX_ELEVATOR_HEIGHT / 2, target.getTarget(0), 0);
	}

	@Test
	public void maxHeight() {
		assertEquals(RobotConfig.MAX_ELEVATOR_HEIGHT, target.getTarget(1), 0);
	}

	@Test
	public void quarterHeight() {
		assertEquals(RobotConfig.MAX_ELEVATOR_HEIGHT / 4, target.getTarget(-0.5), 0);
	}
}
