package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.GyroTurn;

// Changed name from GyroTurn to GyroTurnAutonomous to prevent confusions between the command and the subsystem
public class GyroTurnAutonomous extends CommandBase {
    private double angle;

    public GyroTurnAutonomous(double angle) {
        addRequirements(Robot.gyroTurn);
        this.angle = angle;
    }

    @Override
    public void execute() {
        Robot.gyroTurn.setSetpoint(angle);
    }

    @Override
    public boolean isFinished() {
        // !!! should have been
        // return Robot.gyroTurn.getController().onTarget()
        // but there is no such method as PIDController#onTarget
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.driveTrain.drive(0, 0);
    }
}
