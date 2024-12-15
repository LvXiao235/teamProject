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
        if (isFull() == true)
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

    public String getEmptyrooms(){
        String countStr = "";
        if(!isEmpty()){
            Room emptyRoom = rooms[0];
            for(int i = 1;i < total;i++){
                if(rooms[i].getWhetherRoomOccupied() == false){
                    countStr += rooms[i] + "\n";
                }
            }
        }
        if(countStr == ""){
            return "No room available.";
        }
        else {return countStr;}
    }

    public String getListRooms(){
        return listRooms();
    }
}
