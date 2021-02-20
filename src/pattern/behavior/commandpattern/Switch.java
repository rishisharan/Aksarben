package pattern.behavior.commandpattern;

//Invoker
public class Switch {

    public void storeAndExecuteCommand(Command command){
        command.execute();
    }
}
