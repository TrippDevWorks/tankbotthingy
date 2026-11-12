package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class Drivetrain {
    
  public SparkMax leftMotor1 = new SparkMax(1, MotorType.kBrushed);
  public SparkMax leftMotor2 = new SparkMax(11, MotorType.kBrushed);
  public SparkMax rightMotor1 = new SparkMax(2, MotorType.kBrushed);
  public SparkMax rightMotor2 = new SparkMax(21, MotorType.kBrushed);
  // User Defined Methods
  /**
   * Drive method that sets the same speed to all motors
   * @param speed
   */
  public void drive(double speed) {
    //if (speed <= 1 && speed >=-1) {
        leftMotor1.set(speed);
        leftMotor2.set(speed);
        rightMotor1.set(-speed);
        rightMotor2.set(-speed);
    //}
  }

  /**
   * Robot-centric control of Noodle's tank drive motors
   * 
   * @param speedLeft  speed set to the motors on the left side from -1.0 to 1.0
   * @param speedRight speed set to the motors on the right side from -1.0 to 1.0.
   *                   This value will be inverted by the method.
   */
  public void drive(double speedLeft, double speedRight) {
    leftMotor1.set(speedLeft);
    leftMotor2.set(speedLeft);
    rightMotor1.set(-speedRight);
    rightMotor2.set(-speedRight);
  }
}
