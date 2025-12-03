package Model;

public class Buku {
    private int buku_id;
    private String judul;
    private String penulis;
    private int harga;
    private int stok;

    public Buku(int id, String judul, String penulis, int harga, int stok) {
        this.buku_id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }
    
    // Getter & Setter
    public int getBuku_id() { 
    	return buku_id; 
    }
    
    public void setBuku_id(int id) {
    	this.buku_id = id; 
    }
    
    public String getJudul() {
    	return judul; 
    }
    
    public void setJudul(String judul) {
    	this.judul = judul; 
    }
    
    public String getPenulis() {
    	return penulis; 
    }
    
    public void setPenulis(String penulis) {
    	this.penulis = penulis; 
    }
    
    public int getHarga() {
    	return harga; 
    }
    
    public void setHarga(int harga) { 
    	this.harga = harga; 
    }
    
    public int getStok() {
    	return stok; 
    }
    
    public void setStok(int stok) {
    	this.stok = stok; 
    }
}