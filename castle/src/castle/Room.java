package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, castle.Room> exits = new HashMap<String, castle.Room>();

    public Room(String description) {
        this.description = description;
    }
    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        for (String dir : exits.keySet()) {
            sb.append(dir);
            sb.append(' ');
        }
        return sb.toString();
    }
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    public void setExits(String direction, Room room) {
        exits.put(direction, room);
    }

    @Override
    public String toString()
    {
        return description;
    }
}
