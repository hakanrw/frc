package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShooterRPMSetter extends CommandBase {
    public double power;

    public ShooterRPMSetter(double x) {
        addRequirements(Robot.shooterRPM);
        power = x;
    }

    @Override
    public void execute() {
        Robot.shooterRPM.setSetpoint(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
