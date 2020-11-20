package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ClimbManuel extends CommandBase {
    private double power;

    public ClimbManuel(double power) {
        addRequirements(Robot.tempClimb);
        this.power = power;
    }

    @Override
    public void execute() {
        Robot.tempClimb.climb(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
