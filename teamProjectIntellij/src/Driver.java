import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Store store;

    public static void main(String[] args) {
       new Driver();
    }

    public Driver(){
        runMenu();
    }

    //Menu part 1, print menu and get the number user press
    private int getMenuNumber(){
        System.out.println("""
                Main Menu\
                
                -------------\
                
                1) Initialize the system\
                
                2) Add a new set of rooms\
                
                3) Add one new room\
                
                4) Customer check in/out\
                
                5) Search for empty room\
                
                6) Print all room information\
                
                7) Print one room information\
                
                0) Exit"""
        );
        return input.nextInt();

    }

    private void runMenu(){
        int userPress = getMenuNumber();
        while (userPress != 0){
            switch (userPress){
                case 1 -> howManyRooms();
                case 2 -> addRoomsGroup();
                case 3 -> addRoom();
                case 4 -> changeRoomInformation();
                case 5 -> ListEmptyRooms();
                case 6 -> printRooms();
                case 7 -> SearchRoomNumber();
                default -> System.out.println("Invalid option entered: " + userPress);
            }

            System.out.println("\n Press enter key to continue");
            input.nextLine();
            input.nextLine();

            userPress = getMenuNumber();

        }
        System.out.println("exit now");
        System.exit(0);
    }

    private void addRoom() {
        System.out.println("Enter the room number: ");
        int roomNumber = input.nextInt();
        System.out.println("Enter the room cost (per day): ");
        double roomCost = input.nextDouble();
        System.out.println("Is this room occupied?(y/n)");
        char roomOccupied = input.next().charAt(0);
        boolean whetherRoomOcc = (roomOccupied == 'Y') || (roomOccupied == 'y');
        boolean isAdded = store.add(new Room(roomNumber, roomCost, whetherRoomOcc));
        if (isAdded) {
            System.out.println("Room Added Successfully");
        } else {
            System.out.println("No Product Added");
        }
    }

    private void addRoomsGroup(){
        System.out.println("First room number");
        int roomNumber1 = input.nextInt();
        System.out.println("Last room number");
        int roomNumber2 = input.nextInt();
        System.out.println("All cost");
        double roomCost = input.nextDouble();
        System.out.println("All rooms not occupied");

        for(int i = roomNumber1;i <= roomNumber2;i++){
            boolean isAdded = store.add(new Room(i,roomCost,false));
            if (isAdded){
                System.out.println("Room" + i + " Added Successfully");
            }
            else {
                System.out.println("Room" + i + "didn't added successfully");
            }
        }
    }


    void printRooms(){
        System.out.println("List of rooms are: ");
        System.out.println(store.getListRooms());
    }

    //Set the highest limitation of array
    private void howManyRooms(){
        System.out.println("How many rooms would you like to have in most?");
        int numberRooms = input.nextInt();

        store = new Store(numberRooms);

        System.out.println("How many rooms yo want to set now?");
        int roomsCurrentlyAdded = input.nextInt();

        for(int i = 0;i < roomsCurrentlyAdded;i++){
          addRoom();
        }
    }

    void ListEmptyRooms(){
        System.out.println("Looking for empty rooms...");
        System.out.println(store.getEmptyRooms());
    }

    //Enable user to check somebody in//
    void changeRoomInformation(){
        System.out.println("rOOM xuhao");
        int i = input.nextInt();
        System.out.println("Is this room occupied now");
         char nowWhether =input.next().charAt(0);
        boolean now = (nowWhether == 'y') || (nowWhether == 'Y');
        store.checkInOut(i,now);
    }

    //Enable user to get room information by type in room number//Caution: only can be used when array is full
    void SearchRoomNumber(){
        System.out.println("Which room do you want to check?");
        int roomNumberAim = input.nextInt();
        int total = store.getTotal();
        String roomSearched = "";
        for(int i = 0;i < total;i++){
            if(roomNumberAim == store.getRoomNumber2(i)){
                roomSearched = store.getListSingleProduct(i);
            }
        }

        if(roomSearched != ""){
            System.out.println(roomSearched);
        }
        else {System.out.println("No information");}
    }


}
//Test