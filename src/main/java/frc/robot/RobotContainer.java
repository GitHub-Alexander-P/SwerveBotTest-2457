package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Subsystems.DriveSubsystem;

public class RobotContainer {
DriveSubsystem driveSubsystem = new DriveSubsystem();

Joystick joystick = new Joystick(0);

public RobotContainer() {

    driveSubsystem.setDefaultCommand(
        driveSubsystem.run(
            //This runs the drivetrain, the percentages standing for the maximum speed the bot can achieve.
            () -> driveSubsystem.defaultDrive(joystick.getY(), joystick.getZ(), 0.25, 0.1)
        )
    );

    configureButtons();
}

private void configureButtons(){
    if(joystick.getRawButtonPressed(7)){
        driveSubsystem.resetEncoders();
    }
}
}
