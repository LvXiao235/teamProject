import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Store store;

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.howManyRooms();
        driver.printRooms();
        driver.ListEmptyRooms();
    }

    private void addRoom() {
        System.out.println("Enter the room number: ");
        int roomNumber = input.nextInt();
        System.out.println("Enter the room cost (per day): ");
        double roomCost = input.nextDouble();
        System.out.println("Is this room occupied?(y/n)");
        char roomOccupied = input.next().charAt(0);
        boolean whetherRoomOcc = false;
        if ((roomOccupied == 'Y') || (roomOccupied == 'y')) {
            whetherRoomOcc = true;
        }
        boolean isAdded = store.add(new Room(roomNumber, roomCost, whetherRoomOcc));
        if (isAdded) {
            System.out.println("Room Added Successfully");
        } else {
            System.out.println("No Product Added");
        }
    }
    //void printEmptyRoom(){
    //    store.getEmptyRoom();
    //}

    void printRooms(){
        System.out.println("List of rooms are: ");
        System.out.println(store.getListRooms());
    }

    private void howManyRooms(){
        System.out.println("How many rooms would you like to have in your store?");
        int numberRooms = input.nextInt();

        store = new Store(numberRooms);

        for(int i = 0;i < numberRooms;i++){
          addRoom();
        }
    }

    void ListEmptyRooms(){
        System.out.println("Looking for empty rooms...");
        System.out.println(store.getEmptyrooms());
    }
}
//Test