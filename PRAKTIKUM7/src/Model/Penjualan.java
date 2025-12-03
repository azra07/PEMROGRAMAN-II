package Model;
import java.sql.Date;

public class Penjualan {
    private int penjualan_id;
    private int jumlah;
    private int total_harga;
    private Date tanggal;
    
    private int pelanggan_id;
    private int buku_id;
    
    private String nama_pelanggan;
    private String judul_buku;


    public Penjualan(int id, int jumlah, int total, Date tgl, int pid, int bid) {
        this.penjualan_id = id;
        this.jumlah = jumlah;
        this.total_harga = total;
        this.tanggal = tgl;
        this.pelanggan_id = pid;
        this.buku_id = bid;
    }

    // Setter & Getter
    public void setNamaPelanggan(String nama) {
    	this.nama_pelanggan = nama; 
    }
    
    public String getNamaPelanggan() {
    	return nama_pelanggan; 
    }
    
    public void setJudulBuku(String judul) {
    	this.judul_buku = judul; 
    }
    
    public String getJudulBuku() {
    	return judul_buku; 
    }

    public int getPenjualan_id() {
    	return penjualan_id; 
    }
    
    public void setPenjualan_id(int id) {
    	this.penjualan_id = id; 
    }
    
    public int getJumlah() {
    	return jumlah; 
    }
    
    public void setJumlah(int jumlah) {
    	this.jumlah = jumlah; 
    }
    
    public int getTotal_harga() {
    	return total_harga; 
    }
    
    public void setTotal_harga(int total) {
    	this.total_harga = total; 
    }
    
    public Date getTanggal() {
    	return tanggal; 
    }
    
    public void setTanggal(Date tanggal) {
    	this.tanggal = tanggal; 
    }
    
    public int getPelanggan_id() {
    	return pelanggan_id; 
    }
    
    public void setPelanggan_id(int id) {
    	this.pelanggan_id = id; 
    }
    
    public int getBuku_id() {
    	return buku_id; 
    }
    
    public void setBuku_id(int id) {
    	this.buku_id = id; 
    }
}