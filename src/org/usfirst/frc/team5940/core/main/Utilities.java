package org.usfirst.frc.team5940.core.main;

public interface Utilities {

    public static double InvertAxisIfNeeded(Boolean isAxisInverted, double joystickPosition){
        if (isAxisInverted) {
            return -joystickPosition;
        } else {
            return joystickPosition;
        }
    }
    

}
