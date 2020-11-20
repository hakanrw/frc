package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShooterManuel extends CommandBase {
    private double power;

    public ShooterManuel(double power) {
        this.power = power;
    }

    @Override
    public void execute() {
        Robot.tempShooter.shoot(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
