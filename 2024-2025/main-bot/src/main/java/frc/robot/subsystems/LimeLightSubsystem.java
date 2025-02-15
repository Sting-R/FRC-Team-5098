package frc.robot.subsystems;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.estimator.PoseEstimator;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
// import edu.first.LimelightHelpers;
// import edu.first.wpilibj.

// bunch of random imports 


import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DriverStation.Alliance;


public class LimeLightSubsystem extends SubsystemBase {

  int FLIndex = 0;
  int FRIndex = 1;
  int BLIndex = 2;
  int BRIndex = 3;

  private final SwerveDrivePoseEstimator m_poseEstimator;

  
  public LimeLightSubsystem(CommandSwerveDrivetrain swerveDriveTrain) {

     m_poseEstimator =
      new SwerveDrivePoseEstimator(
          swerveDriveTrain.getKinematics(),
          swerveDriveTrain.getPigeon2().getRotation2d(),
          new SwerveModulePosition[] {
            swerveDriveTrain.getModule(0).getPosition(true),
            swerveDriveTrain.getModule(1).getPosition(true),
            swerveDriveTrain.getModule(2).getPosition(true),
            swerveDriveTrain.getModule(3).getPosition(true)
          },
          new Pose2d(),
          VecBuilder.fill(0.05, 0.05, Units.degreesToRadians(5)),
          VecBuilder.fill(0.5, 0.5, Units.degreesToRadians(30)));
  }



  public void updateOdometry(CommandSwerveDrivetrain swerveDriveTrain) {
    
    m_poseEstimator.update(
      swerveDriveTrain.getPigeon2().getRotation2d(),
      new SwerveModulePosition[] {
        swerveDriveTrain.getModule(0).getPosition(true),
        swerveDriveTrain.getModule(1).getPosition(true),
        swerveDriveTrain.getModule(2).getPosition(true),
        swerveDriveTrain.getModule(3).getPosition(true)
        });


    // Is this boolean ever changing at runtime? If not, it should be a final variable
    boolean useMegaTag2 = true; //set to false to use MegaTag1
    boolean doRejectUpdate = false;
    if(useMegaTag2 == false)
    {
      // Use this line to know whether we are part of an alliance (we might not be if we are not in a match presently)
      // DriverStation.getAlliance().isEmpty()

      // Use this line to know whether we are on the blue alliance
      // DriverStation.getAlliance().get().equals(Alliance.Blue);

      // This should change depending on the alliance we are on
      LimelightHelpers.PoseEstimate mt1 = LimelightHelpers.getBotPoseEstimate_wpiBlue("limelight");
      
      if(mt1.tagCount == 1 && mt1.rawFiducials.length == 1)
      {
        if(mt1.rawFiducials[0].ambiguity > .7)
        {
          doRejectUpdate = true;
        }
        if(mt1.rawFiducials[0].distToCamera > 3)
        {
          doRejectUpdate = true;
        }
      }
      if(mt1.tagCount == 0)
      {
        doRejectUpdate = true;
      }

      if(!doRejectUpdate)
      {
        m_poseEstimator.setVisionMeasurementStdDevs(VecBuilder.fill(.5,.5,9999999));
        m_poseEstimator.addVisionMeasurement(
            mt1.pose,
            mt1.timestampSeconds);
        
        swerveDriveTrain.addVisionMeasurement(
          mt1.pose, 
          mt1.timestampSeconds, 
          VecBuilder.fill(.5,.5,9999999));
      }
    }
    else if (useMegaTag2 == true)
    {
      LimelightHelpers.SetRobotOrientation("limelight", m_poseEstimator.getEstimatedPosition().getRotation().getDegrees(), 0, 0, 0, 0, 0);
      
      // Same thing as above
      LimelightHelpers.PoseEstimate mt2 = LimelightHelpers.getBotPoseEstimate_wpiBlue_MegaTag2("limelight");
      // NOTE! The .getAngularVelocityZWorld() update is different from orignal code. The method .getRate() is depreicated and will be removed soom, so we have switched to this method. However, it is CCW+ instead of CW+, and may not return the same value
      if(Math.abs(swerveDriveTrain.getPigeon2().getAngularVelocityZWorld().getValueAsDouble()) > 720) // if our angular velocity is greater than 720 degrees per second, ignore vision updates
      {
        doRejectUpdate = true;
      }
      if(mt2.tagCount == 0)
      {
        doRejectUpdate = true;
      }
      if(!doRejectUpdate)
      {
        m_poseEstimator.setVisionMeasurementStdDevs(VecBuilder.fill(.7,.7,9999999));
        m_poseEstimator.addVisionMeasurement(
            mt2.pose,
            mt2.timestampSeconds);

        swerveDriveTrain.addVisionMeasurement(
          mt2.pose, 
          mt2.timestampSeconds, 
          VecBuilder.fill(.7,.7,9999999));
      }
    }
  }

  public PoseEstimator getPoseEstimator() {
    return m_poseEstimator;
  }
}
