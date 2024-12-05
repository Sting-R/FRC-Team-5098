package frc.components;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.hal.PowerDistributionFaults;
import edu.wpi.first.hal.PowerDistributionStickyFaults;
import edu.wpi.first.hal.PowerDistributionVersion;

/**
 * Power Distribution Hub Class
 *
 * <p>
 * This class holds methods used for the Power Distribution Hub.
 * </p>
 */
public class PDH {

    /**
     * Number of channels on the Power Distribution Hub.
     */
    private int numChannels;

    /**
     * Power Distribution Hub Object.
     */
    private PowerDistribution pdh;

    /**
     * PDH Constructor.
     *
     * @param id The ID of the Power Distribution Hub
     */
    public PDH(final int id) {
        pdh = new PowerDistribution(id, PowerDistribution.ModuleType.kRev);
        numChannels = pdh.getNumChannels();
    }

    // Power //

    /**
     * Get the overall voltage of the Power Distribution Hub.
     *
     * @return The voltage of the Power Distribution Hub
     */
    public double getTotalVoltage() {
        return pdh.getVoltage();
    }

    /**
     * Get the current of a specific channel on the Power Distribution Hub.
     *
     * @param channel The channel to get the current of
     * @return The current of the channel
     */
    public double getChannelCurrent(final int channel) {
        return pdh.getCurrent(channel);
    }

    /**
     * Get all channel currents of the Power Distribution Hub and return them
     * in an array.
     *
     * @return An array of all channel currents
     */
    public double[] getChannelCurrents() {
        double[] currents = new double[numChannels];
        for (int i = 0; i < numChannels; i++) {
            currents[i] = pdh.getCurrent(i);
        }
        return currents;
    }

    /**
     * Get the total current of the Power Distribution Hub.
     *
     * @return Total current of the Power Distribution Hub
     */
    public double getTotalCurrent() {
        return pdh.getTotalCurrent();
    }

    /**
     * Get the total power of the Power Distribution Hub.
     *
     * @return Total power of the Power Distribution Hub
     */
    public double getTotalPower() {
        return pdh.getTotalPower();
    }

    /**
     * Get the total energy of the Power Distribution Hub.
     *
     * @return Total energy of the Power Distribution Hub
     */
    public double getTotalEnergy() {
        return pdh.getTotalEnergy();
    }
    
    // Faults //

    /**
     * Get any faults on the Power Distribution Hub.
     *
     * @return Faults on the Power Distribution Hub
     */
    public PowerDistributionFaults getFaults() {
        return pdh.getFaults();
    }
    
    /**
     * Get any sticky faults on the Power Distribution Hub.
     *
     * @return Sticky faults on the Power Distribution Hub
     */
    public PowerDistributionStickyFaults getStickyFaults() {
        return pdh.getStickyFaults();
    }
    
    /**
     * Clear all sticky faults on the Power Distribution Hub.
     */
    public void clearStickyFaults() {
        pdh.clearStickyFaults();
    }

    // Miscellaneous //

    /**
     * Get the firmware version of the Power Distribution Hub.
     *
     * @return Firmware version of the Power Distribution Hub
     */
    public PowerDistributionVersion getFirmwareVersion() {
        return pdh.getVersion();
    }

    // Temperature is not available on the PDH :(
}
