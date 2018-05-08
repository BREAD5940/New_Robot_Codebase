package org.usfirst.frc.team5940.core.main;

public interface Utilities {

    public static double InvertAxisIfNeeded(Boolean isAxisInverted, double joystickPosition){
        if (isAxisInverted) {
            return -joystickPosition;
        } else {
            return joystickPosition;
        }
    }

    public static double convertEncoderValueToUnit(double encoderPulsesPerRotation, double outputShaftRadius, double encoderPulses){
        if (encoderPulsesPerRotation != 0){
            double unit = (encoderPulses/ encoderPulsesPerRotation) * Math.PI * Math.pow(outputShaftRadius, 2);
            return unit;
        } else {
            return 0;
        }
    }

    

}
