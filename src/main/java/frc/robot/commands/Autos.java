// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.ConstantsSecondary.SimulationSettings;
import frc.robot.subsystems.SwerveDriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public final class Autos {
  /** Example static factory for an autonomous command. 
  public static Command exampleAuto(SwerveSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }
  */

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }

  public static SequentialCommandGroup autoDriveForwardByTime(SwerveDriveSubsystem swerve){
    return new SequentialCommandGroup(
      new SwerveDriveComboMoveCommand(swerve, SimulationSettings.AutonomousExampleSpeed0, 0., 0., SimulationSettings.AutonomousExampleTimer0),
      new SwerveDriveComboMoveCommand(swerve, 0., SimulationSettings.AutonomousExampleSpeed0, 0., SimulationSettings.AutonomousExampleTimer1)
      );
  }

  public static SequentialCommandGroup autoDriveInTwoDirectionsByTime(SwerveDriveSubsystem swerve){
    return new SequentialCommandGroup(
      new SwerveDriveComboMoveCommand(swerve, SimulationSettings.AutonomousExampleSpeed0, SimulationSettings.AutonomousExampleSpeed0, 0, SimulationSettings.AutonomousExampleTimer0),
      new SwerveDriveComboMoveCommand(swerve, SimulationSettings.AutonomousExampleSpeed1, SimulationSettings.AutonomousExampleSpeed1, 0, SimulationSettings.AutonomousExampleTimer0)
      );
  }
}
