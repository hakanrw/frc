package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.LuckyWheelManuel;

public class TempWheel extends SubsystemBase {

    public TempWheel() {
        setDefaultCommand(new LuckyWheelManuel(0));
    }

    public void turn(double x) {
        RobotMap.luckyWheel.set(ControlMode.PercentOutput, x);
    }
}
