// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.ConstantsSecondary.DriveConstants;
import frc.robot.ConstantsSecondary.OperatorConstants;
import frc.robot.subsystems.SwerveDriveSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class SwerveDriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final SwerveDriveSubsystem m_swerve;

  // run functions and use the return value within each command
  private final Supplier<Double> m_moveForwardFunction, m_moveLeftFunction, m_turnFunction;

  private final SlewRateLimiter xLimiter, yLimiter, turningLimiter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SwerveDriveCommand(SwerveDriveSubsystem swerve, Supplier<Double> moveForward, Supplier<Double> moveLeft, Supplier<Double> rotate) {
    this.m_swerve = swerve;
    this.m_moveLeftFunction = moveLeft;
    this.m_moveForwardFunction = moveForward;
    this.m_turnFunction = rotate;

    this.xLimiter = new SlewRateLimiter(DriveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
    this.yLimiter = new SlewRateLimiter(DriveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
    this.turningLimiter = new SlewRateLimiter(DriveConstants.kTeleDriveMaxAngularAccelerationUnitsPerSecond);

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_swerve);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println(getName() + " started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // get joystick input
    double forwardSpeed = m_moveForwardFunction.get();
    double leftSpeed = m_moveLeftFunction.get();
    double turnSpeed = m_turnFunction.get();

    // apply dead-band to avoid jitter on the joystick
    forwardSpeed = Math.abs(forwardSpeed) > OperatorConstants.kDeadband ? forwardSpeed : 0.0;
    leftSpeed = Math.abs(leftSpeed) > OperatorConstants.kDeadband ? leftSpeed : 0.0;
    turnSpeed = Math.abs(turnSpeed) > OperatorConstants.kDeadband ? turnSpeed : 0.0;

    // make driving smoother
    forwardSpeed = xLimiter.calculate(forwardSpeed) * DriveConstants.kTeleDriveMaxSpeedMetersPerSecond;
    leftSpeed = yLimiter.calculate(leftSpeed) * DriveConstants.kTeleDriveMaxSpeedMetersPerSecond;
    turnSpeed = turningLimiter.calculate(turnSpeed)
                * DriveConstants.kTeleDriveMaxAngularSpeedRadiansPerSecond;

    // chasis speeds
    ChassisSpeeds chassisSpeeds = new ChassisSpeeds(forwardSpeed, leftSpeed, turnSpeed);
    //m_swerve.showChasisSpeedsOnLogger("joystick");
    m_swerve.setChasisSpeeds(chassisSpeeds);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println(getName() + " interrupted!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //System.out.println(getName() + " ended!");
    return false;
  }
}
