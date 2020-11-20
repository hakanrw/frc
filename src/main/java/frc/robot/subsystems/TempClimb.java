package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbManuel;

public class TempClimb extends SubsystemBase {

    public TempClimb() {
        setDefaultCommand(new ClimbManuel(0));
    }

    public void climb(double power) {
        RobotMap.climb1.set(power);
        RobotMap.climb2.set(power);
    }
}
