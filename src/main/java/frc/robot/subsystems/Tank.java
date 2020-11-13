package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.TankManuel;

public class Tank extends SubsystemBase {
    public Tank() {
        setDefaultCommand(new TankManuel(10));
    }

    public void move(double power) {
        RobotMap.tankMotor1.set(power);
        RobotMap.tankMotor2.set(power);
    }
}
