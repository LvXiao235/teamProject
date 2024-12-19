import java.util.Objects;
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
                
                3) Add a new room\
                
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
                case 4 -> checkInOut();
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
        System.out.println("Enter the room number(max 5 numbers): ");
        int roomNumber = input.nextInt();
        System.out.println("How many beds does this room have?");
        int bedNumber = input.nextInt();
        System.out.println("Enter the room cost (per day): ");
        double roomCost = input.nextDouble();
        boolean isAdded = store.add(new Room(roomNumber,bedNumber, roomCost, false));
        if (isAdded) {
            System.out.println("Room Added Successfully");
        } else {
            System.out.println("No Room Added");
        }
    }

    private void addRoomsGroup(){
        System.out.println("First room number");
        int roomNumber1 = input.nextInt();
        System.out.println("Last room number");
        int roomNumber2 = input.nextInt();
        System.out.println("Hoe many beds do these rooms have?");
        int bedNumber = input.nextInt();
        System.out.println("All cost");
        double roomCost = input.nextDouble();
        System.out.println("All rooms not occupied");

        for(int i = roomNumber1;i <= roomNumber2;i++){
            boolean isAdded = store.add(new Room(i,bedNumber,roomCost,false));
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

    }

    void ListEmptyRooms(){
        System.out.println("How many beds?");
        int bedNumber = input.nextInt();
        System.out.println("Looking for empty rooms...");
        System.out.println(store.getEmptyRooms(bedNumber));
    }


    //Enable user to check somebody in//
    void checkInOut(){
        System.out.println("Please enter the room number");
        int roomNumber = input.nextInt();
        int total = store.getTotal();
        for(int i = 0;i < total;i++){
            if(roomNumber == store.getRoomNumber2(i)){
                System.out.println("Is the room occupied now?");
                char roomOccupied = input.next().charAt(0);
                boolean whetherRoomOcc = (roomOccupied == 'Y') || (roomOccupied == 'y');
                if(whetherRoomOcc){
                System.out.println("Enter customer name");
                input.nextLine();
                String customerName = input.nextLine();
                store.checkInOut(i,true,customerName);
                break;}
                else{
                    store.checkInOut(i,false,"Null");
                }
            }
        }
    }

    //Enable user to get room information by type in room number
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

        if(!Objects.equals(roomSearched, "")){
            System.out.println(roomSearched);
        }
        else {System.out.println("No information");}
    }
}
