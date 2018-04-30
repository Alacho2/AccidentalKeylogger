import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.LogManager;

public class JHook implements NativeKeyListener {

    WordHandler wh;
    StringBuilder word;
    Scheduler sch;

    public JHook(){
        wh = new WordHandler();
        word = new StringBuilder();
        sch = new Scheduler();

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
        //Not yet implemented
    }

    public void nativeKeyReleased(NativeKeyEvent nke) {
        if (word.length() > 0 && nke.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
            word.deleteCharAt(word.length() - 1);
        }

        if (!Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) { //If capslock is not active
            if (nke.getKeyCode() == NativeKeyEvent.VC_BACKSPACE){ }
            else if(nke.getKeyCode() == NativeKeyEvent.VC_SPACE){ }
            else if(nke.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK){ }
            else {
                String capsLock = NativeKeyEvent.getKeyText(nke.getKeyCode());
                capsLock = capsLock.toLowerCase();
                word.append(capsLock);
            }
        } else {
            if (nke.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) { }
            else if(nke.getKeyCode() == NativeKeyEvent.VC_SPACE){ }
            else if(nke.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) { }
            else {
                word.append(NativeKeyEvent.getKeyText(nke.getKeyCode()));
            }
        }

        if (nke.getKeyCode() == NativeKeyEvent.VC_SPACE || nke.getKeyCode() == NativeKeyEvent.VC_TAB) {
            wh.addWord(word.toString());
            word.setLength(0); //Clears the buffer
            System.out.println();
            wh.getWords();
        }
    }
}
