package Validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFieldVallidation {

    public static boolean isTextFieldnotEmpty(TextField tf, Label lb, String errorMessage) {
        boolean isValid = true;
        lb.setText("");
        if (tf.getText().trim().isEmpty() || tf.getText().trim().length() == 0) {
            isValid = false;
        }
        lb.setText(errorMessage);
        return isValid;
    }

    public static boolean isTextFieldnotEmpty1(TextField tf, Label lb, String errorMessage) {
        boolean isValid = true;
        lb.setText("");
        if (tf.getText().trim().isEmpty() || tf.getText().trim().length() == 0) {
            isValid = false;
        }
        lb.setText(errorMessage);
        if (tf.getText().matches("[a-zA-Z]+")) {
            isValid = false;
            lb.setText("Vui lòng giá phòng chỉ nhập số");
        }
        return isValid;
    }
}