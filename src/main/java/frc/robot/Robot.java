// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The methods in this class are called automatically corresponding to each
 * mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the
 * package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  public Robot() {
  }

  private Joystick joystick = new Joystick(0);
  private Drivetrain driveTrain = new Drivetrain();

  private double startTime;

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    double decrease = 0.1;
    if (time - startTime < Constants.timeToTurn) {

      driveTrain.drive(Constants.driveSpeed);

    } else if (time - startTime < Constants.endOfTurn) {

      driveTrain.drive(-Constants.turnSpeed +0.06, Constants.turnSpeed);

    } else if (time - startTime < Constants.timeToStop) {

      driveTrain.drive(Constants.driveSpeed);
    } else {
      driveTrain.drive(0, 0);
    }

  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double speed = -joystick.getRawAxis(4) * 0.3;
    double turn = -joystick.getRawAxis(1) * 0.5;

    System.out.println("Speed: " + speed + "  Turn: " + turn);

    double left = speed + turn;
    double right = -speed + turn;

    driveTrain.drive(left,right);

    System.out.println("Speed LM1: " + driveTrain.leftMotor1.get());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
