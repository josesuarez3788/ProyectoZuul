/**
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 */
public class Room {
    private String descRoom; //the room description
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param descRoom The room's description.
     */
    public Room(String description) {
        this.descRoom = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    public String getDescription() {
        return descRoom;
    }

    public void setDescRoom(String descRoom) {
        this.descRoom = descRoom;
    }

    public Room getNorthExit() {
        return northExit;
    }

    public void setNorthExit(Room northExit) {
        this.northExit = northExit;
    }

    public Room getSouthExit() {
        return southExit;
    }

    public void setSouthExit(Room southExit) {
        this.southExit = southExit;
    }

    public Room getEastExit() {
        return eastExit;
    }

    public void setEastExit(Room eastExit) {
        this.eastExit = eastExit;
    }

    public Room getWestExit() {
        return westExit;
    }

    public void setWestExit(Room westExit) {
        this.westExit = westExit;
    }

}
