package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

    // Gyro
    public static ADIS16448_IMU gyro = new ADIS16448_IMU();

    // DriveTrain
    public static SpeedController leftMotor2 = new VictorSP(8);
    public static SpeedController leftMotor1 = new VictorSP(4);
    public static SpeedController rightMotor1= new VictorSP(0);
    public static SpeedController rightMotor2= new VictorSP(7);
    public static SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1, leftMotor2);
    public static SpeedControllerGroup right= new SpeedControllerGroup(rightMotor1,rightMotor2);
    public static DifferentialDrive driveSystem;

    // Climbing
    public static SpeedController climb1 = new VictorSP(3);
    public static SpeedController climb2 = new VictorSP(6);

    // Intake
    public static VictorSPX intake = new VictorSPX(4);

    // Shooter
    public static TalonSRX shooterMotor1 = new TalonSRX(1);
    public static TalonSRX shooterMotor2 = new TalonSRX(2);
    public static TalonSRX shooterAngleMotor = new TalonSRX(3);
    public static Encoder shooterEncoder = new Encoder(0, 1, false, CounterBase.EncodingType.k4X);
    private static double shooterPPR = 2048;
    public static double shooterRPP = shooterPPR ;

    // Wheel
    public static VictorSPX luckyWheel = new VictorSPX(5);

    // Tank
    public static SpeedController tankMotor2 = new VictorSP(9);
    public static SpeedController tankMotor1 = new VictorSP(1);

    // LED
    public static VictorSP led = new VictorSP(2);
}
