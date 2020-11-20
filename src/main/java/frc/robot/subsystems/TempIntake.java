package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.Intake;

public class TempIntake extends SubsystemBase {

    public TempIntake() {
        setDefaultCommand(new Intake(0));
    }

    public void intake(double power) {
        RobotMap.intake.set(ControlMode.PercentOutput, power);
    }
}
