// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveDriveSubsystem;

public class SwerveDriveComboMoveCommand extends Command {
  /** Creates a new SwerveDriveComboMoveCommand. */
  private final SwerveDriveSubsystem m_swerve;

  private final double forwardSpeed, leftSpeed, turnSpeed, timer;
  private ChassisSpeeds m_chassisSpeeds;

  private double timeToStop;

  public SwerveDriveComboMoveCommand(SwerveDriveSubsystem swerve, double forwardSpeed,
                                   double leftSpeed, double turnSpeed, double timer) {

    this.m_swerve = swerve;
    this.forwardSpeed = forwardSpeed;
    this.leftSpeed = leftSpeed;
    this.turnSpeed = turnSpeed;
    this.timer = timer;

    //this.m_chassisSpeeds = new ChassisSpeeds(forwardSpeed, leftSpeed, turnSpeed);
   
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_swerve);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // check if there is a timer set
    timeToStop = 0.;
    if ( timer > 0.) {
      timeToStop = Timer.getFPGATimestamp() + timer;
      SmartDashboard.putNumber("timeToStop", timeToStop);
    }
    SmartDashboard.putNumber("timer", timer);
    System.out.println(getName() + " started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("time now", Timer.getFPGATimestamp());
    //m_swerve.showChasisSpeedsOnLogger("execute");
    m_chassisSpeeds = new ChassisSpeeds(forwardSpeed, leftSpeed, turnSpeed);
    m_swerve.setChasisSpeeds(m_chassisSpeeds);
    //System.out.println(Timer.getFPGATimestamp());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println(getName() + " interrupted!");
    //m_swerve.stopModules();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /*
    if ( timeToStop > 0.) {
      System.out.println(getName() + " not finished!" + String.valueOf(Timer.getFPGATimestamp()));
      if ( isTimedOut() ) {
        m_swerve.stopModules();
        return false;
      }
      return true;
    } else {
      System.out.println(getName() + " finished!" + String.valueOf(Timer.getFPGATimestamp()));;
      return false;
    }
    */
    return isTimedOut();
  }

  private boolean isTimedOut(){
    return Timer.getFPGATimestamp() >= timeToStop;
  }
}
