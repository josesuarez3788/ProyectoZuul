/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 *   
 * 
 */

public class Game {

    private Parser parser;
    private Room currentRoom;
    private Menu menu = new Menu();
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside, theatre, pub, lab, office;
        // Creacion de los cuartos
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        // Inicializar los cuartos existentes
        outside.setExits(null, theatre, lab, pub);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);
        currentRoom = outside;  // Empezar el juego desde afuera
    }

    /**
     *  Rutina play es la principal. Se repite hasta el final del juego.
     */
    public void play() {            
        menu.printWelcome(getCurrentRoom());
        /*
        Ingrese al bucle del comando principal. 
        Aquí leemos comandos repetidamente y los ejecutamos hasta que 
        el juego termina
        */        
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Imprime el mensaje de apertura para el jugador
     */

    /**
     * Dado un comando, procese (es decir: ejecute) el comando.
     * @param command El comando a procesar.
     * @return true si el comando finaliza el juego, false en caso contrario.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    // Implementaciones de los comandos de usuario
    /**
     * Imprime información de ayuda.
     * Aquí imprimimos un mensaje críptico y una lista de los 
     * palabras del comando.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) {
        //Si no hay una segunda palabra, no sabemos adónde ir ...
        if(hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        // Intenta salir de la habitación actual.
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = getCurrentRoom().northExit;
        }
        if(direction.equals("east")) {
            nextRoom = getCurrentRoom().eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = getCurrentRoom().southExit;
        }
        if(direction.equals("west")) {
            nextRoom = getCurrentRoom().westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            moveRoom();
        }
    }

    public void moveRoom(){
        System.out.println("You are " + getCurrentRoom().getDescription());
        System.out.print("Exits: ");
        if(getCurrentRoom().northExit != null) {
            System.out.print("north ");
        }
        if(getCurrentRoom().eastExit != null) {
            System.out.print("east ");
        }
        if(getCurrentRoom().southExit != null) {
            System.out.print("south ");
        }
        if(getCurrentRoom().westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    /** 
     * "Quit" se ingresó. Verifique el resto del comando para ver
     * si realmente abandonamos el juego.
     * @return true si este comando cierra el juego, false en caso contrario
     */
    private boolean quit(Command command) {
        if(hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord(){
        Command command = new Command();
        return (command.getSecondWord() != null);
    }
}
