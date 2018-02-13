package org.usfirst.frc.team340.robot.commands.elevator;

import org.usfirst.frc.team340.robot.Robot;
import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorGoAbovePosition extends Command {

    public ElevatorGoAbovePosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.elevator.getPosition() < RobotMap.ELEVATOR_TRAVEL_POSITION_TICKS) {
    		Robot.elevator.setPosition(RobotMap.ELEVATOR_TRAVEL_POSITION_TICKS);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("pos = " + Robot.elevator.getPosition() + ", state = " + Robot.elevator.isAtBottom());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getPosition() >= RobotMap.ELEVATOR_TRAVEL_POSITION_TICKS;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setBrakeEngaged();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
