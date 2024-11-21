package frc.components;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;

/**
 * RoboRIO Class
 * 
 * <p>
 * This class holds methods used for monitoring the RoboRIO.
 * </p>
 */
public class RoboRIO {
    
    /**
     * Get the CPU temperature of the RoboRIO
     */
    public static double getCPUTemperature() {
        return RoboRioDataJNI.getCPUTemp();
    }

    /**
     * Get the voltage of the RoboRIO
     * 
     * <p>
     * This is the voltage going into the RoboRIO  
     * This does *not* include any channels on the RoboRIO such as DIO, PWM,
     * CAN, etc.
     * </p>
     */
    public static double getVoltage() {
        return RoboRioDataJNI.getVInVoltage();
    }

    /**
     * Get the current of the RoboRIO
     * 
     * <p>
     * This is the current being drawn by the RoboRIO
     * This does *not* include any channels on the RoboRIO such as DIO, PWM,
     * CAN, etc.
     * </p>
     */
    public static double getCurrent() {
        return RoboRioDataJNI.getVInCurrent();
    }

    /**
     * Get the serial number of the RoboRIO
     */
    public static String getSerialNumber() {
        return RoboRioDataJNI.getSerialNumber();
    }
}
