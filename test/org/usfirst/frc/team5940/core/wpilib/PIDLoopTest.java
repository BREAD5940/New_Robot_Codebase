package org.usfirst.frc.team5940.core.wpilib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usfirst.frc.team5940.core.wpilib.PIDLoop;

public class PIDLoopTest {
	
	PIDLoop zeroConstantsPidLoop = new PIDLoop(0, 0, 0);
	
	@Test
	public void zeroConstants_offsetTargetFromPosition() {
		assertEquals(0, zeroConstantsPidLoop.calculate(0.02, 10, 0), 0);
	}
	
	@Test
	public void zeroConstants_sameTargetAsPosition() {
		assertEquals(0, zeroConstantsPidLoop.calculate(0.02, 0, 0), 0);
	}
	
	@Test
	public void zeroConstants_sameTargetAsPosition() {
		assertEquals(0, zeroConstantsPidLoop.calculate(0.02, 4, 4), 0);
	}
}
