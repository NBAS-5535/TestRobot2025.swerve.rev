// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utils;

import edu.wpi.first.math.MathUtil;

public class GamepadUtils {
  public static double squareInput(double _value, double _deadband) {
    return Math.pow(MathUtil.applyDeadband(_value, _deadband), 2) * Math.signum(_value);
  }
}
