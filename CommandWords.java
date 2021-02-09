/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 */

public class CommandWords{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    public CommandWords(){

    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String introducedCommand){
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(introducedCommand))
                return true;
        }
        return false;
    }
}
