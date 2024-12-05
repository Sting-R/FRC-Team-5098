package frc;

/**
 * CommonData Class
 * <p>
 * This class is used to store common data that is used throughout the code.
 * </p>
 */
public final class CommonData {

    /**
     * Private constructor to prevent instantiation.
     */
    private CommonData() {
        throw new UnsupportedOperationException(
            "This is a utility class and cannot be instantiated");
    }

    // NavX Data //

    /**
     * NavX Yaw.
     */
    private static double navXYaw;

    /**
     * NavX Pitch.
     */
    private static double navXPitch;

    /**
     * NavX Roll.
     */
    private static double navXRoll;

    /**
     * NavX Acceleration X.
     */
    private static double navXAccelX;

    /**
     * NavX Acceleration Y.
     */
    private static double navXAccelY;

    /**
     * NavX Acceleration Z.
     */
    private static double navXAccelZ;

    /**
     * NavX Temperature.
     */
    private static double navXTemp;

    // Getters //

    /**
     * Get the NavX Yaw.
     *
     * @return The NavX Yaw
     */
    public static double getNavXYaw() {
        return navXYaw;
    }

    /**
     * Get the NavX Pitch.
     *
     * @return The NavX Pitch
     */
    public static double getNavXPitch() {
        return navXPitch;
    }

    /**
     * Get the NavX Roll.
     *
     * @return The NavX Roll
     */
    public static double getNavXRoll() {
        return navXRoll;
    }

    /**
     * Get the NavX Acceleration X.
     *
     * @return The NavX Acceleration X
     */
    public static double getNavXAccelX() {
        return navXAccelX;
    }

    /**
     * Get the NavX Acceleration Y.
     *
     * @return The NavX Acceleration Y
     */
    public static double getNavXAccelY() {
        return navXAccelY;
    }

    /**
     * Get the NavX Acceleration Z.
     *
     * @return The NavX Acceleration Z
     */
    public static double getNavXAccelZ() {
        return navXAccelZ;
    }

    /**
     * Get the NavX Temperature.
     *
     * @return The NavX Temperature
     */
    public static double getNavXTemp() {
        return navXTemp;
    }

    // Setters //

    /**
     * Set the NavX Yaw.
     *
     * @param yaw The Yaw to set
     */
    public static void setNavXYaw(final double yaw) {
        navXYaw = yaw;
    }

    /**
     * Set the NavX Pitch.
     *
     * @param pitch The Pitch to set
     */
    public static void setNavXPitch(final double pitch) {
        navXPitch = pitch;
    }

    /**
     * Set the NavX Roll.
     *
     * @param roll The Roll to set
     */
    public static void setNavXRoll(final double roll) {
        navXRoll = roll;
    }

    /**
     * Set the NavX Acceleration X.
     *
     * @param accelX The Acceleration X to set
     */
    public static void setNavXAccelX(final double accelX) {
        navXAccelX = accelX;
    }

    /**
     * Set the NavX Acceleration Y.
     *
     * @param accelY The Acceleration Y to set
     */
    public static void setNavXAccelY(final double accelY) {
        navXAccelY = accelY;
    }

    /**
     * Set the NavX Acceleration Z.
     *
     * @param accelZ The Acceleration Z to set
     */
    public static void setNavXAccelZ(final double accelZ) {
        navXAccelZ = accelZ;
    }

    /**
     * Set the NavX Temperature.
     *
     * @param temp The Temperature to set
     */
    public static void setNavXTemp(final double temp) {
        navXTemp = temp;
    }
}
