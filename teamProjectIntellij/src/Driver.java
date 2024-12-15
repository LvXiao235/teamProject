import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Store store;

    public static void main(String[] args) {
        /*Driver driver = */new Driver();
        /*driver.howManyRooms();
        driver.printRooms();
        driver.ListEmptyRooms();*/
    }

    public Driver(){
        howManyRooms();
        runMenu();
    }

    //Menu part 1, print menu and get the number user press
    private int getMenuNumber(){
        System.out.println("Main Menu" +
                "\n-------------" +
                "\n1) Set rooms" +
                "\n2) Customer check in/out" +
                "\n3) Search for empty room" +
                "\n4) Print room information" +
                "\n0) Exit"
        );
        int userPress = input.nextInt();
        return userPress;

    }

    private void runMenu(){
        int userPress = getMenuNumber();
        if (userPress != 0){
            switch (userPress){
                case 1 -> addRoom();
                case 2 -> changeRoomInformation();
                case 3 -> ListEmptyRooms();
                case 4 -> printRooms();
                default -> System.out.println("Invalid option entered: " + userPress);
            }

            System.out.println("\n Press enter key to continue");
            input.nextLine();
            input.nextLine();

            userPress = getMenuNumber();

            System.out.println("exit now");
            System.exit(0);
        }
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

    //Enable user to check somebody in//  Doesn't work. It will exit if you press 2
    void changeRoomInformation(){
        System.out.println("rOOM xuhao");
        int i = input.nextInt();
        System.out.println("now");
         char nowWhether =input.next().charAt(0);
        boolean now = false;
        if((nowWhether == 'y')||(nowWhether == 'Y')){
            now = true;
        }
        store.checkInOut(i,now);

    }


}
//Test