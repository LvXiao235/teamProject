public class Room {
    private int roomNumber;
    private double roomCost;
    private boolean whetherRoomOcc;

    Room(int roomNumber,double roomCost,boolean whetherRoomOcc){
        this.roomNumber = roomNumber;
        this.roomCost = roomCost;
        this.whetherRoomOcc = whetherRoomOcc;
    }

    public String toString(){
        return "Room Number: " + roomNumber
                + ",room cost(per night): " + roomCost
                +",Whether the Room is occupied: " + whetherRoomOcc;
    }
}
