package org.usfirst.frc.team5940.robots.baguette;

public class RobotUtilities {
    
    public static double convertEncoderValueToUnit(double encoderPulsesPerRotation, double outputShaftRadius, double encoderPulses){
        if (encoderPulsesPerRotation != 0){
            double unit = (encoderPulses/ encoderPulsesPerRotation) * Math.PI * Math.pow(outputShaftRadius, 2);
            return unit;
        } else {
            return 0;
        }
    }

}
