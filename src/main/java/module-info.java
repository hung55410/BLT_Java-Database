module sample.login2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.commons;
    requires de.jensd.fx.glyphs.fontawesome;


    opens sample.login2 to javafx.fxml;
    exports sample.login2;
    exports Controller;
    opens Controller to javafx.fxml;
}