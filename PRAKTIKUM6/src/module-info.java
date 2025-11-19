module PRAKTIKUM6 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;

	opens application to javafx.graphics, javafx.fxml;
	opens Controller to javafx.fxml;
	opens Model to javafx.base;
}