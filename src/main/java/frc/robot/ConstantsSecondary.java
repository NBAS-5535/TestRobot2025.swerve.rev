// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ConstantsSecondary {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kDriverYAxis = 0;
    public static final int kDriverXAxis = 1;
    public static final int kDriverRotAxis = 4;

    public static final double kDeadband = 0.05;

  }

  public static final class OffsetConstants {
    // distance to motors from the chasis center
    private static final double xLengthInInches = 23.; //in inches pointing upwards
    private static final double yLengthInInches = 23.; //in inches point to the left
    public static final double chasisXOffset = Units.inchesToMeters(xLengthInInches) / 2.;
    public static final double chasisYOffset = Units.inchesToMeters(yLengthInInches) / 2.;
  }

  public static final class SwerveMotorDeviceConstants {
    public static final int kFrontLeftSteerMotorCANId = 2;
    public static final int kFrontRightSteerMotorCANId = 3;
    public static final int kBackRightSteerMotorCANId = 8;
    public static final int kBackLeftSteerMotorCANId = 6;

    public static final int kFrontLeftDriveMotorCANId = 1;
    public static final int kFrontRightDriveMotorCANId = 4;
    public static final int kBackRightDriveMotorCANId = 7;
    public static final int kBackLeftDriveMotorCANId = 5;

    public static final int kFrontLeftCANcoderCANId = 31;
    public static final int kFrontRightCANcoderCANId = 33;
    public static final int kBackRightCANcoderCANId = 32;
    public static final int kBackLeftCANcoderCANId = 34;

    public static final double kFrontLeftCANcoderOffsetRad = 2.669; //0.313965;
    public static final double kFrontRightCANcoderOffsetRad = 2.723; //0.366699;
    public static final double kBackRightCANcoderOffsetRad = 0.159668;
    public static final double kBackLeftCANcoderOffsetRad = -0.456055;

    public static final boolean kFrontLeftDriveMotorInverted = false;
    public static final boolean kBackLeftDriveMotorInverted = false;
    public static final boolean kFrontRightDriveMotorInverted = false;
    public static final boolean kBackRightDriveMotorInverted = false;

    public static final boolean kFrontLeftSteerMotorInverted = false;
    public static final boolean kBackLeftSteerMotorInverted = false;
    public static final boolean kFrontRightSteerMotorInverted = false;
    public static final boolean kBackRightSteerMotorInverted = false;

    public static final boolean kFrontLeftCANcoderInverted = false;
    public static final boolean kBackLeftCANcoderInverted = false;
    public static final boolean kFrontRightCANcoderInverted = false;
    public static final boolean kBackRightCANcoderInverted = false;

  }

  public static final class DriveConstants {
    public static final double kPhysicalMaxSpeedMetersPerSecond = 5;
    public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

    public static final double kTeleDriveMaxSpeedMetersPerSecond = 1;//kPhysicalMaxSpeedMetersPerSecond / 4;
    public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = //
            kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
    public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 1;//3;
    public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 1;//3;
  }

  public static final class ModuleConstants {
    public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
    public static final double kDriveMotorGearRatio = 1 / 5.8462;
    public static final double kTurningMotorGearRatio = 1 / 18.0;
    public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
    public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
    public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
    public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;
    public static final double kPSteer = 0.1;//0.5;

    // NEO motor specs
    // Encoder resolution
    public static final double unitPerRotation = 42.;
  }

  public static final class DeviceConstants{
    public static final int gyroscopeChannelId = 0;

  }
  public static boolean simtest = false;
  public static final class SimulationSettings {

    public static final double AutonomousExampleSpeed0 = 0.3;
    public static final double AutonomousExampleTimer0 = 5.;
    public static final double AutonomousExampleSpeed1 = 0.4;
    public static final double AutonomousExampleTimer1 = 7.;

  }
}
