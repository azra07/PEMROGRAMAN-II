package PRAK201_2410817120001_PutriFatimaAzhara;

public class Buah {
	private String namaBuah;
    private double berat;
    private double harga;
    private double jumlahBeli;
    private double sebelumDiskon;
    private double totalDiskon;
    private double setelahDiskon;
    public Buah(String namaBuah, double berat, double harga, double jumlahBeli) {
        this.namaBuah = namaBuah;
        this.berat = berat;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
        this.sebelumDiskon = jumlahBeli / berat * harga;
        double kelipatan;
        if (this.jumlahBeli >= 4) {
            kelipatan = this.jumlahBeli / 4;
        } else {
            kelipatan = 0.0;
        }
        this.totalDiskon = 0.02 * (4 * this.harga) * Math.floor(kelipatan);
        this.setelahDiskon = this.sebelumDiskon - this.totalDiskon;
    }
    public void tampilkan() {
        System.out.println("Nama Buah: " + this.namaBuah);
        System.out.println("Berat: " + this.berat);
        System.out.println("Harga: " + this.harga);
        System.out.printf("Jumlah Beli: %.1fkg\n", this.jumlahBeli);
        System.out.printf("Harga Sebelum Diskon: Rp%.2f \n", this.sebelumDiskon);
        System.out.printf("Total Diskon: Rp%.2f\n", this.totalDiskon);
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n", this.setelahDiskon);
        System.out.println();
    }

}