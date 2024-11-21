package frc.subsystems.sensors;

import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;
import edu.wpi.first.wpilibj.SPI; // This is for a fallback Gyro

import frc.CommonData;

public class NavX {

    /**
     * NavX Object
     */
    private AHRS navX;

    /**
     * NavX Constructor
     */
    public NavX() {
        navX = new AHRS(NavXComType.kMXP_SPI);
    }

    /**
     * Reset the NavX
     */
    public void reset() {
        navX.reset();
    }

    /**
     * Get if the NavX is calibrating
     * 
     * @return If the NavX is calibrating
     */
    public boolean isCalibrating() {
        return navX.isCalibrating();
    }

    /**
     * NavX Update method
     * <p>
     * This method is used to update the NavX data and publish it to CommonData.
     * This is called via the Sensor.update() method within the Robot.java file.
     * </p>
     * <p>
     * This uses the IComponent interface
     * </p>
     */
    public void update() {
        CommonData.navXYaw = navX.getYaw();
        CommonData.navXPitch = navX.getPitch();
        CommonData.navXRoll = navX.getRoll();
        CommonData.navXAccelX = navX.getWorldLinearAccelX();
        CommonData.navXAccelY = navX.getWorldLinearAccelY();
        CommonData.navXAccelZ = navX.getWorldLinearAccelZ();
        CommonData.navXTemp = navX.getTempC();
    }
}
