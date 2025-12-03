package Controller;

import java.sql.Date;
import Service.BukuService;
import Service.PelangganService;
import Service.PenjualanService;
import Model.Buku;
import Model.Pelanggan;
import Model.Penjualan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    private final PelangganService pelangganService = new PelangganService();
    private final BukuService bukuService = new BukuService();
    private final PenjualanService penjualanService = new PenjualanService();

    private int selectedPelangganId = 0;
    private int selectedBukuId = 0;
    private int selectedPenjualanId = 0;

    //PELANGGAN
    @FXML private TextField pNama, pEmail, pTelepon;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colPNama, colPEmail, colPTelepon;

    //BUKU
    @FXML private TextField bJudul, bPenulis, bHarga, bStok;
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> colBJudul, colBPenulis;
    @FXML private TableColumn<Buku, Integer> colBHarga, colBStok;

    //PENJUALAN
    @FXML private TextField txtJNamaPelanggan, txtJJudulBuku, jJumlah, jTotal; 
    @FXML private DatePicker jTanggal;
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, String> colJNamaPelanggan, colJJudulBuku;
    @FXML private TableColumn<Penjualan, Integer> colJJumlah, colJTotal;
    @FXML private TableColumn<Penjualan, Date> colJTanggal;

    @FXML
    public void initialize() {
        setupColumns();
        setupListeners();
        loadAllData();
    }

    private void setupColumns() {
        colPNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colPEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        colBJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        colBPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        colBHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colBStok.setCellValueFactory(new PropertyValueFactory<>("stok"));

        colJNamaPelanggan.setCellValueFactory(new PropertyValueFactory<>("namaPelanggan"));
        colJJudulBuku.setCellValueFactory(new PropertyValueFactory<>("judulBuku"));
        colJJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colJTotal.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
        colJTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
    }

    private void setupListeners() {
        // Listener Pelanggan
        tblPelanggan.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                selectedPelangganId = newVal.getPelanggan_id();
                pNama.setText(newVal.getNama());
                pEmail.setText(newVal.getEmail());
                pTelepon.setText(newVal.getTelepon());
            }
        });

        // Listener Buku
        tblBuku.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                selectedBukuId = newVal.getBuku_id();
                bJudul.setText(newVal.getJudul());
                bPenulis.setText(newVal.getPenulis());
                bHarga.setText(String.valueOf(newVal.getHarga()));
                bStok.setText(String.valueOf(newVal.getStok()));
            }
        });

        // Listener Penjualan
        tblPenjualan.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                selectedPenjualanId = newVal.getPenjualan_id();
                txtJNamaPelanggan.setText(newVal.getNamaPelanggan());
                txtJJudulBuku.setText(newVal.getJudulBuku());
                jJumlah.setText(String.valueOf(newVal.getJumlah()));
                jTotal.setText(String.valueOf(newVal.getTotal_harga()));
                if (newVal.getTanggal() != null) jTanggal.setValue(newVal.getTanggal().toLocalDate());
            }
        });
    }

    //CRUD Pelanggan
    @FXML void addPelanggan() {
        try {
            Pelanggan p = new Pelanggan(0, pNama.getText(), pEmail.getText(), pTelepon.getText());
            pelangganService.addPelanggan(p);
            onSuccess("Pelanggan ditambahkan!");
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }
    
    @FXML void updatePelanggan() {
        if(selectedPelangganId==0) { showAlert("Warning","Pilih data!"); return; }
        try {
            Pelanggan p = new Pelanggan(selectedPelangganId, pNama.getText(), pEmail.getText(), pTelepon.getText());
            pelangganService.editPelanggan(p);
            onSuccess("Pelanggan diedit!");
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML void deletePelanggan() {
        if(selectedPelangganId==0) { showAlert("Warning","Pilih data!"); return; }
        try {
            pelangganService.deletePelanggan(selectedPelangganId);
            onSuccess("Pelanggan dihapus!");
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    //CRUD Buku
    @FXML void addBuku() {
        try {
            if (bJudul.getText() == null || bJudul.getText().trim().isEmpty()) {
                throw new Exception("Judul buku tidak boleh kosong!");
            }

            if (bPenulis.getText() == null || bPenulis.getText().trim().isEmpty()) {
                throw new Exception("Penulis buku tidak boleh kosong!");
            }

            if (bHarga.getText().trim().isEmpty()) throw new Exception("Harga tidak boleh kosong!");
            if (bStok.getText().trim().isEmpty()) throw new Exception("Stok tidak boleh kosong!");

            int harga, stok;
            try {
                harga = Integer.parseInt(bHarga.getText());
                stok = Integer.parseInt(bStok.getText());
            } catch (NumberFormatException e) { 
                throw new Exception("Harga dan Stok harus berupa angka!"); 
            }

            Buku b = new Buku(0, bJudul.getText(), bPenulis.getText(), harga, stok);
            bukuService.addBuku(b);
            
            onSuccess("Buku berhasil ditambahkan!");

        } catch (Exception e) { 
            showAlert("Gagal", e.getMessage()); 
        }
    }
    
    @FXML void updateBuku() {
        if(selectedBukuId==0) { showAlert("Warning","Pilih data!"); return; }
        try {
            Buku b = new Buku(selectedBukuId, bJudul.getText(), bPenulis.getText(), Integer.parseInt(bHarga.getText()), Integer.parseInt(bStok.getText()));
            bukuService.editBuku(b);
            onSuccess("Buku diedit!");
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML void deleteBuku() {
        if(selectedBukuId==0) { showAlert("Warning","Pilih data!"); return; }
        try {
            bukuService.deleteBuku(selectedBukuId);
            onSuccess("Buku dihapus!");
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    //CRUD Penjualan
    @FXML void addPenjualan() {
        try {
            String inputNama = txtJNamaPelanggan.getText();
            String inputJudul = txtJJudulBuku.getText();
            
            if (inputNama.isEmpty()) throw new Exception("Isi Nama Pelanggan!");
            if (inputJudul.isEmpty()) throw new Exception("Isi Judul Buku!");
            if (jJumlah.getText().isEmpty()) throw new Exception("Isi Jumlah!");

            if (jTanggal.getValue() == null) {
                throw new Exception("Tanggal harus diisi!");
            }

            int jumlah;
            try {
                jumlah = Integer.parseInt(jJumlah.getText());
            } catch (NumberFormatException e) {
                throw new Exception("Jumlah harus berupa angka!");
            }

            int pid = -1;
            for(Pelanggan p : pelangganService.getAllPelanggan()) {
                if(p.getNama().equalsIgnoreCase(inputNama)) {
                    pid = p.getPelanggan_id();
                    break;
                }
            }
            if(pid == -1) throw new Exception("Pelanggan '" + inputNama + "' tidak ditemukan! Cek ejaan/huruf besar kecil.");

            int bid = -1;
            for(Buku b : bukuService.getAllBuku()) {
                if(b.getJudul().equalsIgnoreCase(inputJudul)) {
                    bid = b.getBuku_id();
                    break;
                }
            }
            if(bid == -1) throw new Exception("Buku '" + inputJudul + "' tidak ditemukan! Cek ejaan/huruf besar kecil.");

            Penjualan p = new Penjualan(0, jumlah, 0, Date.valueOf(jTanggal.getValue()), pid, bid);
            
            penjualanService.addPenjualanAuto(p); 
            
            onSuccess("Transaksi Berhasil!");

        } catch (Exception e) { 
            showAlert("Gagal", e.getMessage()); 
        }
    }

    @FXML
    void updatePenjualan() {
        if (selectedPenjualanId == 0) {
            showAlert("Warning", "Pilih transaksi di tabel terlebih dahulu!");
            return;
        }

        try {
            String inputNama = txtJNamaPelanggan.getText();
            String inputJudul = txtJJudulBuku.getText();

            if (inputNama.isEmpty()) throw new Exception("Isi Nama Pelanggan!");
            if (inputJudul.isEmpty()) throw new Exception("Isi Judul Buku!");
            if (jJumlah.getText().isEmpty()) throw new Exception("Isi Jumlah!");
            if (jTanggal.getValue() == null) throw new Exception("Isi Tanggal!");

            int pid = -1;
            for (Pelanggan p : pelangganService.getAllPelanggan()) {
                if (p.getNama().equalsIgnoreCase(inputNama)) {
                    pid = p.getPelanggan_id();
                    break;
                }
            }
            if (pid == -1) throw new Exception("Pelanggan '" + inputNama + "' tidak ditemukan! Cek ejaan.");

            int bid = -1;
            int hargaBuku = 0;
            for (Buku b : bukuService.getAllBuku()) {
                if (b.getJudul().equalsIgnoreCase(inputJudul)) {
                    bid = b.getBuku_id();
                    hargaBuku = b.getHarga(); 
                    break;
                }
            }
            if (bid == -1) throw new Exception("Buku '" + inputJudul + "' tidak ditemukan! Cek ejaan.");

            int jumlah;
            try {
                jumlah = Integer.parseInt(jJumlah.getText());
            } catch (NumberFormatException e) {
                throw new Exception("Jumlah harus berupa angka!");
            }
            
            int totalBaru = hargaBuku * jumlah; 

            Penjualan p = new Penjualan(selectedPenjualanId, jumlah, totalBaru, Date.valueOf(jTanggal.getValue()), pid, bid);

            penjualanService.editPenjualan(p);

            onSuccess("Transaksi berhasil diedit!");

        } catch (Exception e) {
            showAlert("Gagal", e.getMessage());
        }
    }

    @FXML void deletePenjualan() {
        if(selectedPenjualanId==0) { showAlert("Warning", "Pilih transaksi!"); return; }
        try {
            penjualanService.deletePenjualan(selectedPenjualanId);
            onSuccess("Transaksi dihapus!");
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    private void loadAllData() {
        try {
            tblPelanggan.setItems(FXCollections.observableArrayList(pelangganService.getAllPelanggan()));
            tblBuku.setItems(FXCollections.observableArrayList(bukuService.getAllBuku()));
            tblPenjualan.setItems(FXCollections.observableArrayList(penjualanService.getAllPenjualan()));
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void onSuccess(String msg) {
        showAlert("Sukses", msg);
        pNama.clear(); pEmail.clear(); pTelepon.clear(); selectedPelangganId=0;
        bJudul.clear(); bPenulis.clear(); bHarga.clear(); bStok.clear(); selectedBukuId=0;
        txtJNamaPelanggan.clear(); txtJJudulBuku.clear(); jJumlah.clear(); jTotal.clear(); jTanggal.setValue(null); selectedPenjualanId=0;
        loadAllData();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(title.equals("Gagal")||title.equals("Error")?Alert.AlertType.ERROR:Alert.AlertType.INFORMATION);
        alert.setTitle(title); alert.setHeaderText(null); alert.setContentText(msg); alert.show();
    }
}