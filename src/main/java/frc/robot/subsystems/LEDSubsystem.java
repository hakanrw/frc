package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LEDSubsystem extends SubsystemBase {

    public void light(double power) {
        RobotMap.led.set(power);
    }
}
