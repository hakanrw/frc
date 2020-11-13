package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TankManuel extends CommandBase {

    private double power;

    public TankManuel(double p) {
        addRequirements(Robot.tank);
        power = p;
    }

    @Override
    public void execute() {
        Robot.tank.move(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.tank.move(0);
    }
}
