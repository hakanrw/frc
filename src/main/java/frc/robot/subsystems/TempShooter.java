package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterManuel;

public class TempShooter extends SubsystemBase {
    private TalonSRX localShooter = RobotMap.shooterMotor1;

    public TempShooter() {
        setDefaultCommand(new ShooterManuel(0));
    }

    public void shoot(double power) {
        localShooter.set(ControlMode.PercentOutput, power);
    }
}
