package pattern.behavior.commandpattern;

import java.util.ArrayList;
import java.util.List;

public class CommandDemo {
    public static void main(String[] args) {
        Light bedRoomLight = new Light();
        Light kitchenLight = new Light();

        Switch lightSwitch = new Switch();
        Command toggleCommand = new ToggleCommand(bedRoomLight);
        lightSwitch.storeAndExecuteCommand(toggleCommand );
     //   lightSwitch.storeAndExecuteCommand(toggleCommand );
//        lightSwitch.storeAndExecuteCommand(toggleCommand );
//        lightSwitch.storeAndExecuteCommand(toggleCommand );

        List<Light> lights = new ArrayList<>();
        lights.add(kitchenLight);
        lights.add(bedRoomLight);
        Command allLightsCommand = new AllLightsCommand(lights);
        lightSwitch.storeAndExecuteCommand(allLightsCommand);

    }
}
