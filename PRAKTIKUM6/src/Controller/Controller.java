package Controller;

import Model.Mahasiswa;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
	@FXML
    private TableView<Mahasiswa> tableView;

    @FXML
    private TableColumn<Mahasiswa, String> nimColumn;

    @FXML
    private TableColumn<Mahasiswa, String> namaColumn;
    
    @FXML
    void initialize() {
    	nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tableView.getItems().add(new Mahasiswa(1, "2410817120001", "Putri Fatima Az'hara"));
        tableView.getItems().add(new Mahasiswa(2, "2410817220018", "Anggraeni Dwi Zahra"));
        tableView.getItems().add(new Mahasiswa(3, "2410817320001", "Nazla Salsabila"));
        tableView.getItems().add(new Mahasiswa(4, "2410817320010", "Rabiah Riska Amaliah"));
        tableView.getItems().add(new Mahasiswa(5, "2410817220030", "Rachel Wina Yuda"));
        tableView.getItems().add(new Mahasiswa(6, "2410817220022", "Amanda Arva Safaraya"));
        tableView.getItems().add(new Mahasiswa(7, "2410817220012", "Noor Khalisa"));
        tableView.getItems().add(new Mahasiswa(8, "2410817120015", "Adinda Lestari"));
        tableView.getItems().add(new Mahasiswa(9, "2410817220023", "Clarissa Dhea Allisya"));
        tableView.getItems().add(new Mahasiswa(10, "2410817320015", "Nazwa Amanda"));


    }
}