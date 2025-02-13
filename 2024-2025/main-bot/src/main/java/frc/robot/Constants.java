// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kAuxiliaryControllerPort = 1;
  }
  // PLACEHOLDER IDS!!!
  public static class ElevatorConstants {
    public static final int kElevatorLeftMotorPort = 12;
    public static final int kElevatorRightMotorPort = 13;
    public static final double kMotorElevatorSpeed = 0.2;
    public static final int kElevatorEncoderBottomValue = 0;
    public static final int kElevatorEncoderTopValue = 1000;

    public static class ElevatorPreset {
      // PLACEHOLDER VALUES!!!
      public static final double level1EncoderValue = 0.5;
      public static final double level2EncoderValue = 1.0;
      public static final double level3EncoderValue = 1.5;
      public static final double level4EncoderValue = 2.0;
    }
  }
  public static final class AlgaeArmConstants {
    public static final int algaeArmBarID = 8;//placeholder
  }
  public static class CoralArmConstants {
    public static final int coralArmID = 69;//placeholder with funny number hehe
    public static final int kCoralEncoderTopValue = 1000;
    public static final int kCoralEncoderTopBuffer = kCoralEncoderTopValue + 10;
    public static final int kCoralEncoderBottomValue = 0;
    public static final int kCoralEncoderBottomBuffer = kCoralEncoderBottomValue - 10;
  }
}
