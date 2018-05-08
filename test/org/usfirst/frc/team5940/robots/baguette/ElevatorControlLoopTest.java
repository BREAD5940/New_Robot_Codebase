package org.usfirst.frc.team5940.robots.baguette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.usfirst.frc.team5940.robots.baguette.ElevatorControlLoop;

public class ElevatorControlLoopTest {

	@Test
	public void test() {
		ElevatorControlLoop testLoop = new ElevatorControlLoop();
		assertEquals(12, testLoop.update(0.5, 1000, 0), 0);
	}
}
