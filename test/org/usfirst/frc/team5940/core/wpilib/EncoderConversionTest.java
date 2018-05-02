package org.usfirst.frc.team5940.core.wpilib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usfirst.frc.team5940.core.wpilib.EncoderConversion;

public class EncoderConversionTest {

	EncoderConversion zeroRadiusEncoderConverter = new EncoderConversion(400, 0);
	EncoderConversion zeroPulsesPerRotationEncoderConverter = new EncoderConversion(0, 0);

	EncoderConversion twoRadiusTenPulsesPerRotationEncoderConverter = new EncoderConversion(10, 2);

	@Test
	public void zeroRadius_convert3300() {
		assertEquals(0, zeroRadiusEncoderConverter.convert(3300), 0);
	}

	@Test
	public void zeroRadius_convert0() {
		assertEquals(0, zeroRadiusEncoderConverter.convert(0), 0);
	}

	@Test
	public void zeroRadius_convertNegative400() {
		assertEquals(0, zeroRadiusEncoderConverter.convert(-400), 0);
	}

	@Test
	public void zeroPulsesPerRotation_convert3300() {
		assertEquals(0, zeroPulsesPerRotationEncoderConverter.convert(3300), 0);
	}

	@Test
	public void zeroPulsesPerRotation_convert0() {
		assertEquals(0, zeroPulsesPerRotationEncoderConverter.convert(0), 0);
	}

	@Test
	public void twoRadiusTenPulsesPerRotation_convert0() {
		assertEquals(0, twoRadiusTenPulsesPerRotationEncoderConverter.convert(0), 0);
	}

	@Test
	public void twoRadiusTenPulsesPerRotation_convert50() {
		assertEquals(20 * Math.PI, twoRadiusTenPulsesPerRotationEncoderConverter.convert(50), 0);
	}

	@Test
	public void twoRadiusTenPulsesPerRotation_convertNegative50() {
		assertEquals(-20 * Math.PI, twoRadiusTenPulsesPerRotationEncoderConverter.convert(-50), 0);
	}
}
