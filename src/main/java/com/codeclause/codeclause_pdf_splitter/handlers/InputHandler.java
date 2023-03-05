package com.codeclause.codeclause_pdf_splitter.handlers;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class InputHandler extends TextField {
    public InputHandler(){
        this.addEventFilter(KeyEvent.KEY_TYPED, t -> {
            char enteredChar = t.getCharacter().charAt(0);
            if (!(enteredChar >= '0' && enteredChar <= '9')){
                clear();
            }
        });
    }
}
