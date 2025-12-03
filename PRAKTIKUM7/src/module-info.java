module Praktikum7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens application to javafx.graphics, javafx.fxml;
    opens Controller to javafx.fxml;
    opens Model to javafx.base;
}