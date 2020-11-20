package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterAngleManuel;

public class TempShooterAngle extends SubsystemBase {

    public TempShooterAngle() {
        setDefaultCommand(new ShooterAngleManuel(0));
    }

    public void turn(double power) {
        RobotMap.shooterAngleMotor.set(ControlMode.PercentOutput, power);
    }
}
