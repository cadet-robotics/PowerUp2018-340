package org.usfirst.frc.team340.robot.commands.elevator;

import org.usfirst.frc.team340.robot.Robot;
import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorGoUp extends Command {

    public ElevatorGoUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.goUp(RobotMap.ELEVATOR_FULLSPEED_VBUS *.75);
    	Robot.elevator.setTiltForward();
    	Robot.elevator.getPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("pos = " + Robot.elevator.getPosition() + ", state = " + Robot.elevator.isAtBottom());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
