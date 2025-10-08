package PRAK202_2410817120001_PutriFatimaAzhara;

public class Kopi {
	String namaKopi;
    String ukuran;
    double harga;
    private String pembeli;
    public void info() {
        System.out.println("Nama Kopi: " + namaKopi);
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Harga: " + harga);
    }
    public String getPembeli() {
        return pembeli;
    }
    public void setPembeli(String pembeliBaru) {
        this.pembeli = pembeliBaru;
    }
    public double getPajak() {
        return harga * 0.11;
    }

}