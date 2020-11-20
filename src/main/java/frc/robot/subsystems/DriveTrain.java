package frc.robot.subsystems;


import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDrive;

public class DriveTrain extends SubsystemBase {
    public final double Kp = 0.02;

    public DriveTrain() {
        setDefaultCommand(new JoystickDrive());
    }

    public void drive(double x, double y) {
        RobotMap.driveSystem.tankDrive(x, y);
    }

    public void drive(Joystick joy, double mult) {
        drive(joy.getRawAxis(1) * mult, joy.getRawAxis(3) * -mult);
    }

    public void gyroDrive(ADIS16448_IMU gyro, boolean x) {
        gyro.reset();
        double angle = gyro.getAngle();
        if(x) {

            RobotMap.left.setVoltage((-angle * Kp + 0.3) * 12);
            RobotMap.right.setVoltage((0.3 + angle * Kp) * 12);
        }
        else {
            RobotMap.left.setVoltage((angle * Kp + 0.3) * -12);
            RobotMap.right.setVoltage((0.3 - angle * Kp) * -12);
        }
        Timer.delay(0.0004);
    }


}
