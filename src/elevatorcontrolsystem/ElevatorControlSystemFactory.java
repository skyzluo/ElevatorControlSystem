/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorcontrolsystem;

public interface ElevatorControlSystemFactory {
  public void pickUp(Integer pickUpFloor);
  public void destination(Integer elevatorId, Integer destinationFloor);
  public void step();

}