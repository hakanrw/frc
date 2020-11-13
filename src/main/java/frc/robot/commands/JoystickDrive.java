package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class JoystickDrive extends CommandBase {

    public JoystickDrive() {
        addRequirements(Robot.driveTrain);
    }

    @Override
    public void execute() {
        Robot.driveTrain.drive(Robot.IO.joy1, 0.5);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupt) {
        Robot.driveTrain.drive(0,0);
    }

}
