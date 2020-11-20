package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ShooterAngle extends CommandBase {

    public ShooterAngle() {
        addRequirements(Robot.visionSystem);
    }

    @Override
    public void initialize() {
        RobotMap.led.set(1);
        Robot.visionSystem.enable();
    }

    @Override
    public void execute() {
        Robot.visionSystem.getController().setSetpoint(0);
    }

    @Override
    public boolean isFinished() {
        // !!! should have been
        // return Robot.visionSystem.getController().onTarget()
        // but there is no such method as PIDController#onTarget
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        RobotMap.led.set(0);
        Robot.visionSystem.disable();
    }
}
