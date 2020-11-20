package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LuckyWheelManuel extends CommandBase {
    private double power;

    public LuckyWheelManuel(double power) {
        this.power = power;
    }

    @Override
    public void execute() {
        Robot.tempWheel.turn(power);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
