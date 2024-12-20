public class Room {
    private int roomNumber;
    private double roomCost;
    private int bedNumber;
    private boolean whetherRoomOcc;
    private String customerName = "Null";


    Room(int roomNumber,int bedNumber,double roomCost,boolean whetherRoomOcc){
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.roomCost = roomCost;
        this.whetherRoomOcc = whetherRoomOcc;

    }

    public String toString(){
        return "Room Number: " + roomNumber
                + ", This room has " + bedNumber + " beds"
                + ",  room cost(per night): " + roomCost
                +",  Whether the Room is occupied: " + whetherRoomOcc
                +",  Customer name: "+customerName;
    }

    public boolean getWhetherRoomOccupied() {
        return whetherRoomOcc;
    }

    public void checkIn(boolean whetherRoomOcc,String customerName){
        this.whetherRoomOcc=whetherRoomOcc;
        this.customerName=customerName;

    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public int getBedNumber(){
        return bedNumber;
    }
}
