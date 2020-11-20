package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class VisionTargetting extends PIDSubsystem {

    public VisionTargetting() {
        super(new PIDController(-0.25, -0.002, 0));

        getController().setTolerance(2);
        getController().enableContinuousInput(-60, 60);
        getController().setIntegratorRange(-0.2, 0.2);
    }

    @Override
    protected double getMeasurement() {
        return Robot.visionTable.getEntry("targetYaw").getDouble(0);
    }

    @Override
    protected void useOutput(double output, double setPoint) {
        RobotMap.shooterAngleMotor.set(ControlMode.PercentOutput, output);
    }
}
