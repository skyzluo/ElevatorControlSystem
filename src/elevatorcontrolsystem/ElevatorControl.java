package elevatorcontrolsystem;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class ElevatorControl implements ElevatorControlSystemFactory {

  public static final int MAX_ELEVATORS = 16;
  Integer numberOfElevators = 0;
  Integer numberOfFloors = 0;
  ArrayList<Elevator> elevators;
  Queue<Integer> pickupLocations;

// Constructor
  public ElevatorControl(Integer numberOfElevators, Integer numberOfFloors) throws InvalidNumber {
    if (numberOfElevators < 0) throw new InvalidNumber("Elevator number must be positive");
    // make sure the number of elevators does not exceed the Max number allowed
    this.numberOfElevators = (numberOfElevators > MAX_ELEVATORS)?MAX_ELEVATORS:numberOfElevators;
    this.numberOfFloors = numberOfFloors;
    initializeElevators();
    pickupLocations = new LinkedList<Integer>();
  }

//Initialize elevators
  private void initializeElevators(){
    elevators = new ArrayList<Elevator>();
    for (int idx=0;idx<this.numberOfElevators;idx++){
      elevators.add(new Elevator(1));
    }
  }

  public ArrayList<Elevator> getElevators(){
    return elevators;
  }

  @Override
  public void pickUp(Integer pickUpFloor) {
    pickupLocations.add(pickUpFloor);
  }

  @Override
  public void destination(Integer elevatorId, Integer destinationFloor) {
    elevators.get(elevatorId).addNewDestinatoin(destinationFloor);
  }

  @Override
  public void step() {
    // Loop though every elevator
    for (Elevator currElevator : elevators){
      // Check to figure out which ones are unoccupied and update call
      switch (currElevator.status()){
        case ELEVATOR_EMPTY:
          if (!pickupLocations.isEmpty())
            currElevator.addNewDestinatoin(pickupLocations.poll());
          break;
        // Move occupied Elevators one step closer to next closest destination in direction
        case ELEVATOR_OCCUPIED:
          switch (currElevator.direction()){
            case ELEVATOR_UP:
              currElevator.moveUp();
              break;
            case ELEVATOR_DOWN:
              currElevator.moveDown();
              break;
            case ELEVATOR_HOLD:
              // TODO: Check timer here to alert users that they are holding the door open to long
              // TODO: Emergency situation where elevator can't be used
              // TODO: Maintenance Mode e.g. movers or maintenance people
              //stop to let people exit
              currElevator.popDestination();
              break;
          }
          if (currElevator.direction() == ElevatorDirection.ELEVATOR_UP) 
             break;  //may not be useful; only breaks switch (currElevator.status())
      }
    }
  }
}
