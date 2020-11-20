package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class GyroDrive extends CommandBase {
    private boolean direction;

    public GyroDrive(boolean direction) {
        this.direction = direction;
        addRequirements(Robot.driveTrain);
    }

    @Override
    public void execute() {
        Robot.driveTrain.gyroDrive(RobotMap.gyro, direction);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
