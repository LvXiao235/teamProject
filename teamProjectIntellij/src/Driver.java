import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Store store;

    public static void main(String[] args) {

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

    private void roomOrder(){
        System.out.println("How many rooms would you like to have in your store?");
        int numberRooms = input.nextInt();

        store = new Store(numberRooms);

        for(int i = 1;i < numberRooms;i++){
          addRoom();
        }
    }

}
//Test