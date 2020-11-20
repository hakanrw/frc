/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private CommandBase m_autoSelected;
  private final SendableChooser<CommandBase> m_chooser = new SendableChooser<>();

  public static OI IO;

  // Subsystems
  public static DriveTrain driveTrain = new DriveTrain();
  public static GyroTurn gyroTurn = new GyroTurn();
  public static ShooterRPM shooterRPM = new ShooterRPM();
  public static LEDSubsystem ledSubsystem = new LEDSubsystem();
  public static Tank tank = new Tank();
  public static TempIntake tempIntake = new TempIntake();
  public static TempWheel tempWheel = new TempWheel();
  public static TempShooter tempShooter = new TempShooter();
  public static TempShooterAngle tempShooterAngle = new TempShooterAngle();
  public static VisionTargetting visionSystem = new VisionTargetting();
  public static TempClimb tempClimb = new TempClimb();

  // Camera
  public static NetworkTable visionTable;
  public static CameraServer cameraServer;
  public static UsbCamera visionCam;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    IO = new OI();
    RobotMap.driveSystem = new DifferentialDrive(RobotMap.left, RobotMap.right);
    RobotMap.leftMotor1.setInverted(true);
    RobotMap.leftMotor2.setInverted(true);
    RobotMap.gyro.calibrate();

    // Camera
    cameraServer = CameraServer.getInstance();
    visionCam = cameraServer.startAutomaticCapture();
    visionCam.setResolution(640, 480);
    visionTable = NetworkTableInstance.getDefault().getTable("chamelon-vision").getSubTable("ps3-eye camera");

    m_chooser.setDefaultOption("Default Auto", new AutonomousCommand());
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

    CommandScheduler.getInstance().run();
    /*
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
     */
  }

  /**
   * This function is called once when teleop is enabled.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  /**
   * This function is called once when the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  /**
   * This function is called periodically when disabled.
   */
  @Override
  public void disabledPeriodic() {
  }

  /**
   * This function is called once when test mode is enabled.
   */
  @Override
  public void testInit() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
