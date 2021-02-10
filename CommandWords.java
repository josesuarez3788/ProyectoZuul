/**
 * Testa clase es parte de la aplicación "World of Zuul".
 * "World of Zuul" es un juego de aventuras basado en texto muy simple.
 * Esta clase contiene una enumeración de todas las palabras de comando conocidas en el juego.
 * Se utiliza para reconocer los comandos a medida que se escriben.
 */

public class CommandWords{
    private final String commandGo = "go";
    private final String commandQuit = "quit";
    private final String commandHelp = "help";

    public CommandWords(){

    }

    public String getCommandGo() {
        return commandGo;
    }

    public String getCommandQuit() {
        return commandQuit;
    }

    public String getCommandHelp() {
        return commandHelp;
    }

    /**
     * Verifique si una cadena dada es una palabra de comando válida. 
     * @return verdadero si una cadena dada es un comando válido,
     *  falso si no lo es.
     */
    public boolean isCommand(String introduceCommand) {
        
        if(introduceCommand.equals(this.commandGo)) {
            return true;
        }
        if(introduceCommand.equals(this.commandHelp)) {
            return true;
        }
        if(introduceCommand.equals(this.commandQuit)) {
            return true;
        }
        return false;
    }
}
