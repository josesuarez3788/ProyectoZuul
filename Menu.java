public class Menu {
    public void printWelcome(Room currentRoom) {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");

        if(currentRoom.getNorthExit() != null) {
            System.out.print("north ");
        }
        if(currentRoom.getEastExit() != null) {
            System.out.print("east ");
        }
        if(currentRoom.getSouthExit() != null) {
            System.out.print("south ");
        }
        if(currentRoom.getWestExit() != null) {
            System.out.print("west ");
        }
        System.out.println();
    }
}
