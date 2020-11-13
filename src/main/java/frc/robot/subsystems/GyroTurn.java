package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.RobotMap;

public class GyroTurn extends PIDSubsystem {

    public GyroTurn() {
        // Possible misunderstanding of Kp and period values. Check later.
        super(new PIDController(0.02, 0, 0));
        getController().enableContinuousInput(-180, 180);
        getController().setIntegratorRange(-4, 4);
        getController().setTolerance(4);
    }

    @Override
    protected void useOutput(double output, double setpoint) {
        RobotMap.left.setVoltage(-output);
        RobotMap.right.setVoltage(output);
    }

    @Override
    protected double getMeasurement() {
        return RobotMap.gyro.getAngle();
    }
}
