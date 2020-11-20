package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousCommand extends SequentialCommandGroup {

    public AutonomousCommand() {
        addCommands(
            new GyroTurnAutonomous(-45),
            new GyroDrive(true).withTimeout(0.8)
        );
        Timer.delay(0.5);
        addCommands(
            new GyroTurnAutonomous(0),
            parallel(new Intake(-1).withTimeout(3)),
            new GyroDrive(false).withTimeout(2),
            new GyroDrive(true).withTimeout(2),
            new GyroTurnAutonomous(-45)
        );
        Timer.delay(0.5);
        addCommands(new GyroDrive(false).withTimeout(0.8));
        Timer.delay(0.5);
        addCommands(new GyroTurnAutonomous(0));
    }
}
