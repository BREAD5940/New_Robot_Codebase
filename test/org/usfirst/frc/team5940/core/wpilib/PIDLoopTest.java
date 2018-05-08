package org.usfirst.frc.team5940.core.wpilib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PIDLoopTest {

	@Test
	public void noError() {
		PID loop = new PID(0, 0, 0);
		assertEquals(0, loop.calculate(1, 0, 0), 0);
	}

	@Test
	public void kP() {
		PID loop = new PID(5, 0, 0);
		assertEquals(25, loop.calculate(0.5, 0, 10), 0);
	}
	
	@Test
	public void kI() {
		PID loop = new PID(0, 5, 0);
		assertEquals(25, loop.calculate(0.5, 0, 10), 0);
		assertEquals(37.5, loop.calculate(0.5, 5, 10), 0);
	}

	@Test
	public void kD() {
		PID loop = new PID(0, 0, 5);
		assertEquals(0, loop.calculate(0.5, 0, 10), 0);
		assertEquals(12.5, loop.calculate(0.5, 5, 10), 0);
	}
}
