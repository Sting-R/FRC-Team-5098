// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimesliceRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The methods in this class are called automatically corresponding to each
 * mode, as described in the TimesliceRobot documentation. If you change the
 * name of this class or the package after creating this project, you must also
 * update the Main.java file in the project.
 */
public class Robot extends TimesliceRobot {
  
  /**
   * The period of the robot loop.
   */
  private static final double kRobotPeriod = 0.005;

  /**
   * The period of the controller loop.
   */
  private static final double kControllerPeriod = 0.01;

  /**
   * The period of the first controller loop.
   */
  private static final double kController1Period = 0.002;

  /**
   * The period of the second controller loop.
   */
  private static final double kController2Period = 0.002;
  
  /**
   * Robot constructor.
   */
  public Robot() {
    // Run robot periodic() functions for 5 ms, and run controllers every 10 ms
    super(kRobotPeriod, kControllerPeriod);

    // LiveWindow causes drastic overruns in robot periodic functions that will
    // interfere with controllers
    LiveWindow.disableAllTelemetry();

    // Runs for 2 ms after robot periodic functions
    schedule(() -> {}, kController1Period);

    // Runs for 2 ms after first controller function
    schedule(() -> {}, kController2Period);

    // Total usage:
    // 5 ms (robot) + 2 ms (controller 1) + 2 ms (controller 2) = 9 ms
    // 9 ms / 10 ms -> 90% allocated
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
