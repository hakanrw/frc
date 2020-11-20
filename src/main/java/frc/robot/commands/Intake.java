package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Intake extends CommandBase {
    private double power;

    public Intake(double power) {
        addRequirements(Robot.tempIntake);
        this.power = power;
    }

    @Override
    public void execute() {
        Robot.tempIntake.intake(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
