package pattern.behavior.commandpattern;

import java.util.List;

public class ToggleCommand implements Command{

    private Light light;
    public ToggleCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.toggle();
    }
}
