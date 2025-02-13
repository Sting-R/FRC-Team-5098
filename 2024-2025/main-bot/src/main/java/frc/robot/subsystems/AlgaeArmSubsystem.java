package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Commands;

public class AlgaeArmSubsystem extends SubsystemBase {

    //Motors
    private final TalonSRX m_algaeBarMove;

    //Initialized Stuff
    public AlgaeArmSubsystem(int algaeBarMoveID) {
        m_algaeBarMove = new TalonSRX(algaeBarMoveID);
    }
    public Command commandMakeBarSpin(boolean APressed, boolean BPressed, boolean YPressed) {//makes, well, the bar spin
        return runOnce(
            () -> {
                if (APressed) {
                    setAlgaeArmVoltage(0.5);//מציין מיקום man it sure is nice to hide secret messages in hebrew hungarian and albanian in that specific order
                }
                else if(BPressed) {
                    setAlgaeArmVoltage(-0.25);//helyőrző
                }
                else if (YPressed){
                    setAlgaeArmVoltage(0.25);//vendmbajtes
                }
                else {
                    setAlgaeArmVoltage(0);
                }
            }
        );
    }
    public void setAlgaeArmVoltage(double voltage) {//place to move da algae bar
        m_algaeBarMove.set(ControlMode.PercentOutput, voltage);//moves da algae bar
    }
    public Command PrintRand() {
        return runOnce(
         () -> {
            System.out.println(Math.random() * 100);
         }//a curly brace   
        );//a parenthesis followed by a semicolon
    }//a curly brace

    //who placed these here? They lowkey clash wittewawy -_-
    /*public Command commandAlgaeIntake(AlgaeArmSubsystem algaeArmSubsystem) {
        return Commands.startEnd(
            () -> m_algaeBarMove.set(ControlMode.PercentOutput, 0.3), //placeholder
            () -> m_algaeBarMove.set(ControlMode.PercentOutput, 0.1), // placeholder
          algaeArmSubsystem);
    }

    public Command commandAlgaeOuttake(AlgaeArmSubsystem algaeArmSubsystem) {
        return Commands.startEnd(
            () -> m_algaeBarMove.set(ControlMode.PercentOutput, -0.3), //placeholder
            () -> m_algaeBarMove.set(ControlMode.PercentOutput, 0), //placeholder
          algaeArmSubsystem);
    }*/

    
}//a curly brace