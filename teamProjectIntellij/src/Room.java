public class Room {
    private int roomNumber;
    private double roomCost;
    private boolean whetherRoomOcc;
    //private String customerName = "Null";


    Room(int roomNumber,double roomCost,boolean whetherRoomOcc){
        this.roomNumber = roomNumber;
        this.roomCost = roomCost;
        this.whetherRoomOcc = whetherRoomOcc;

    }

    public String toString(){
        return "Room Number: " + roomNumber
                + ",  room cost(per night): " + roomCost
                +",  Whether the Room is occupied: " + whetherRoomOcc;
                //+",test"+customerName;
    }

    public boolean getWhetherRoomOccupied() {
        return whetherRoomOcc;
    }

    public void checkIn(boolean whetherRoomOcc){
        this.whetherRoomOcc=whetherRoomOcc;

    }

    public int getRoomNumber(){
        return roomNumber;
    }
}
