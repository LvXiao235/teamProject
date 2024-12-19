public class Store {
    private Room[] rooms;
    private int total = 0;
    int i = 0;

    public Store(int i) {
        rooms = new Room[i];
    }

    private boolean isFull() {
        return (total == rooms.length);
    }

    private boolean isEmpty() {
        return (total == 0);
    }

    public boolean add(Room room) {
        if (isFull())
            return false;
        else rooms[total] = room;
        total += 1;
        return true;
    }

    private String listRooms() {
        if (isEmpty())
            return "No rooms added";
        else {
            String list0fRooms = "";
            for (i = 0; i < total; i++) {
                list0fRooms += i + ";" + rooms[i] + "\n";
            }
            return list0fRooms;
        }
    }

    private String listSingleRoom(int i){

        String aRoom;
        aRoom = rooms[i].toString();
        return aRoom;
    }

    public String getEmptyRooms(int bedNumber){
        String countStr = "";
        //isEmpty means  the array is empty
        if(!isEmpty()){
            for(int i = 0;i < total;i++){
                if(rooms[1].getBedNumber() == bedNumber) {
                    if (!rooms[i].getWhetherRoomOccupied()) {
                        countStr += rooms[i] + "\n";
                    }
                }
            }
        }
        if(countStr.isEmpty()){
            return "No room available.";
        }
        else {return countStr;}
    }

    public String getListRooms(){
        return listRooms();
    }

    public void checkInOut(int i,boolean now,String customerName){
        rooms[i].checkIn(now,customerName);
    }

    public int getTotal(){
        return total;
    }

    public int getRoomNumber2(int i){
        return rooms[i].getRoomNumber();
    }

    public String getListSingleProduct(int i){
        return listSingleRoom(i);
    }

    /*public void changeRoomInformation(int i){

    }*/


}
