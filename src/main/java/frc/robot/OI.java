package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;

public class OI {
    public Joystick joy1 = new Joystick(0);
    public Joystick joy2 = new Joystick(1);

    public Button green = new JoystickButton(joy1, 2);
    public Button red = new JoystickButton(joy1, 3);
    public Button blue = new JoystickButton(joy1, 1);
    public Button yellow = new JoystickButton(joy1, 4);
    public Button L1 = new JoystickButton(joy1, 5);
    public Button R1 = new JoystickButton(joy1, 6);
    public Button L2 = new JoystickButton(joy1, 7);
    public Button R2 = new JoystickButton(joy1, 8);
    public Button back = new JoystickButton(joy1, 9);
    public Button start = new JoystickButton(joy1, 10);


    public Button green2 = new JoystickButton(joy2, 1);
    public Button red2 = new JoystickButton(joy2, 2);
    public Button blue2 = new JoystickButton(joy2, 3);
    public Button yellow2 = new JoystickButton(joy2, 4);
    public Button L12 = new JoystickButton(joy2, 5);
    public Button R12= new JoystickButton(joy2, 6);
    public Button back2 = new JoystickButton(joy2, 7);
    public Button start2 = new JoystickButton(joy2, 8);
    public Button L32 = new JoystickButton(joy2, 9);
    public Button R32 = new JoystickButton(joy2, 10);

    public OI() {

        // - Chassis driver -
        // Angle adjusting
        blue.whileHeld(new ShooterAngleManuel(1));
        red.whileHeld(new ShooterAngleManuel(-1));

        // Shooter
        L1.whileHeld(new ShooterManuel(1));

        // Intake
        R1.whileHeld(new Intake(-1));

        // PID
        R2.whileHeld(new ShooterRPMSetter(5500));
        L2.whileHeld(new ShooterAngle());


        // - Secondary driver -
        // Tank
        yellow2.whileHeld(new TankManuel(1));
        green2.whileHeld(new TankManuel(-1));

        // Wheel
        blue2.whileHeld(new LuckyWheelManuel(1));
        red2.whileHeld(new LuckyWheelManuel(-1));

        // Elevator
        start2.whileHeld(new ClimbManuel(-0.5));
        back2.whileHeld(new ClimbManuel(0.5));
    }
}
