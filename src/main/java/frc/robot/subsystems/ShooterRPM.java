/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterRPMSetter;

public class ShooterRPM extends PIDSubsystem {

    public ShooterRPM() {
        // Intert a subsystem name and PID values here
        super(new PIDController(0.2, 0, 0));

        getController().setTolerance(100);
        getController().enableContinuousInput(0, 6000);
        getController().setIntegratorRange(-0.5, 0.5);

        setDefaultCommand(new ShooterRPMSetter(5500));
    }


    @Override
    protected double getMeasurement() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return RobotMap.shooterEncoder.getRate()*60;
    }

    @Override
    protected void useOutput(double output, double setpoint) {
        // Use output to drive your system, like a motor
        RobotMap.shooterMotor1.set(ControlMode.Follower,2);
        RobotMap.shooterMotor2.set(ControlMode.PercentOutput,1+output);
    }
}
