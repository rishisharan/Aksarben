package pattern.behavior.commandpattern;

import java.security.PublicKey;

//Receiver
public class Light {

    private boolean isOn = false;

    public boolean isOn(){
        return isOn;
    }
    public void toggle(){
        if( isOn ){
            off();
            isOn = false;
        }else {
            isOn = true;
            on();
        }
    }

    public void on(){
        System.out.println("Light switched on.");
    }

    public void off(){
        System.out.println("Light switched off.");
    }

}
