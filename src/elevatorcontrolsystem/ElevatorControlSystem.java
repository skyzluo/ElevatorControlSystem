package elevatorcontrolsystem;

public class ElevatorControlSystem {
    public static void main(String[] args) throws InvalidNumber {
        //System.out.println("Hello world!");
        int numberOfElevators=2;
        int numberOfFloors=20;
        ElevatorControl system=new ElevatorControl(numberOfElevators, numberOfFloors); //5 elevators and 20 floors
        system.pickUp(5);
        system.pickUp(4);
        system.pickUp(15);
        system.pickUp(11);
        system.pickUp(17);
        
        for (int i=0; i<8; i++)
             system.step();
        
        for (int idx=0;idx<numberOfElevators;idx++){
             System.out.println(system.elevators.get(idx).currentFloor());
             System.out.println(system.elevators.get(idx).status());
      }
       System.out.println("Quit");

    }
    
}
