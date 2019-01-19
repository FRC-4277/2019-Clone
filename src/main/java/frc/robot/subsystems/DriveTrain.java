/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DrivewithJoystick;

public class DriveTrain extends Subsystem {

  private WPI_TalonSRX rightback = new WPI_TalonSRX(58);
  private WPI_TalonSRX rightfront = new WPI_TalonSRX(60);
  private WPI_TalonSRX leftfront = new WPI_TalonSRX(61);
  private WPI_TalonSRX leftback = new WPI_TalonSRX(59);

  SpeedControllerGroup r_wheel = new SpeedControllerGroup(rightback, rightfront);
  SpeedControllerGroup l_wheel = new SpeedControllerGroup(leftback, leftfront);
  DifferentialDrive diffDrive = new DifferentialDrive(r_wheel, l_wheel);

  public void drive(Joystick joystick) {
    diffDrive.arcadeDrive(joystick.getY(), -joystick.getZ());
  }

  public DriveTrain() {
    super();
  }

  public void stop() {
    diffDrive.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DrivewithJoystick());
  }
}
