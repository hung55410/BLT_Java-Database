package Validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFieldVallidation {

    public static boolean isTextFieldnotEmpty(TextField tf, Label lb, String errorMessage) {
        boolean isValid = true;
        lb.setText("");
        if(tf.getText().trim().isEmpty()){
            isValid = false;
            lb.setText(errorMessage);
        }
        return isValid;
    }
}