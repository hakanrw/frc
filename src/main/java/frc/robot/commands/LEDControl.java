package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LEDControl extends CommandBase {
    private double power;

    public LEDControl(double power) {
        this.power = power;
    }

    @Override
    public void execute() {
        Robot.ledSubsystem.light(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
