package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

// Changed name from ManuelAngle to ShooterAngleManuel
public class ShooterAngleManuel extends CommandBase {
    private double power;

    public ShooterAngleManuel(double power) {
        addRequirements(Robot.tempShooterAngle);
        this.power = power;
    }

    @Override
    public void execute() {
        Robot.tempShooterAngle.turn(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
