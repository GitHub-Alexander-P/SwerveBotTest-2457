package frc.robot.Subsystems;

import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{

    //Declaring the drive motors for this class only.
    private CANSparkMax frightDrive = new CANSparkMax(5, MotorType.kBrushless);
    private CANSparkMax fleftDrive = new CANSparkMax(7, MotorType.kBrushless);
    private CANSparkMax bleftDrive = new CANSparkMax(9, MotorType.kBrushless);
    private CANSparkMax brightDrive = new CANSparkMax(11, MotorType.kBrushless);

    //Declaring the turn motors for this class only.
    private CANSparkMax frightTurning = new CANSparkMax(4, MotorType.kBrushless);
    private CANSparkMax fleftTurning = new CANSparkMax(6, MotorType.kBrushless);
    private CANSparkMax brightTurning = new CANSparkMax(10, MotorType.kBrushless);
    private CANSparkMax bleftTurning = new CANSparkMax(8, MotorType.kBrushless);

    //Storing encoders for turn SHAFT in this class only.
    private CANCoder frightCC = new CANCoder(0);
    private CANCoder fleftCC = new CANCoder(1);
    private CANCoder bleftCC = new CANCoder(2);
    private CANCoder brightCC = new CANCoder(3);

    //Declare some storage variables for use later.
    private double frightAV;
    private double fleftAV;
    private double bleftAV;
    private double brightAV;

    //Grouping together the drive and turn motors in this class only.
    private final MotorControllerGroup drivers = new MotorControllerGroup(frightDrive, fleftDrive, brightDrive, bleftDrive);
    private final MotorControllerGroup turners = new MotorControllerGroup(frightTurning, fleftTurning, brightTurning, bleftTurning);

    //Default driving command ran in RobotContainer.java, runs the drivetrain.
    public void defaultDrive(double fwd, double rot, double fwdPercent, double rotPercent){
        //Store absolute value positions inside variables.
        frightAV = frightCC.getAbsolutePosition();
        fleftAV = fleftCC.getAbsolutePosition();
        bleftAV = bleftCC.getAbsolutePosition();
        brightAV = brightCC.getAbsolutePosition();

        //Set the drive motor group to move at half power.
        drivers.set(fwd * fwdPercent);

        //Sets a margin of error for the bot so the turn motors don't drift.
        if(rot < 0.1 || rot > -0.1){
            turners.set(rot * rotPercent);
        } else {
            if(frightAV>fleftAV){
                
            }
        }

        //Print out the absolute value positions of 
        System.out.println("AFR:" + frightCC.getAbsolutePosition());
        System.out.println("AFL:" + fleftCC.getAbsolutePosition());
        System.out.println("BLL:" + bleftCC.getAbsolutePosition());
        System.out.println("BLR:" + brightCC.getAbsolutePosition());
    }

    public void resetEncoders(){
        frightCC.setPosition(0);
        fleftCC.setPosition(0);
        bleftCC.setPosition(0);
        brightCC.setPosition(0);
    }
}
