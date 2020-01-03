/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExampleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private boolean isOn = false;
  private NetworkTableInstance inst = NetworkTableInstance.getDefault();
  private NetworkTable table;
  private NetworkTableEntry myEntry;

  public ExampleSubsystem() {
//    inst.startClient("localhost");
    table = inst.getTable("LED");
    myEntry = table.getEntry("isOn");
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void toggleLED() {
    if (isOn == true) {
      isOn = false;
    } else {
      isOn = true;
    }
    myEntry.setBoolean(isOn);
  }
  public void turnonLed(){
    myEntry.setBoolean(true);
  }
}
