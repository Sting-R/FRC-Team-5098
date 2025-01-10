package frc.components;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;

/**
 * RoboRIO Class.
 *
 * <p>
 * This class holds methods used for monitoring the RoboRIO.
 * </p>
 */
public final class RoboRIO {

    /**
     * Private constructor to prevent instantiation.
     */
    private RoboRIO() {
        throw new UnsupportedOperationException(
            "This is a utility class and cannot be instantiated");
    }

    /**
     * Get the CPU temperature of the RoboRIO.
     *
     * @return The CPU temperature of the RoboRIO
     */
    public static double getCPUTemperature() {
        return RoboRioDataJNI.getCPUTemp();
    }

    /**
     * Get the voltage of the RoboRIO.
     *
     * <p>
     * This is the voltage going into the RoboRIO
     * This does *not* include any channels on the RoboRIO such as DIO, PWM,
     * CAN, etc.
     * </p>
     *
     * @return The voltage of the RoboRIO
     */
    public static double getVoltage() {
        return RoboRioDataJNI.getVInVoltage();
    }

    /**
     * Get the current of the RoboRIO.
     *
     * <p>
     * This is the current being drawn by the RoboRIO
     * This does *not* include any channels on the RoboRIO such as DIO, PWM,
     * CAN, etc.
     * </p>
     *
     * @return The current of the RoboRIO
     */
    public static double getCurrent() {
        return RoboRioDataJNI.getVInCurrent();
    }

    /**
     * Get the serial number of the RoboRIO.
     *
     * @return The serial number of the RoboRIO
     */
    public static String getSerialNumber() {
        return RoboRioDataJNI.getSerialNumber();
    }
}
