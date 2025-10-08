package PRAK203_2410817120001_PutriFatimaAzhara;

public class Soal3Main {
	 public static void main(String[] args) {
	        Pegawai p1 = new Pegawai();
	        // Pada baris ini terjadi error karena kurangnya titik koma (;)
	        // p1.nama = "Roi"
	        p1.nama = "Roi";
	        p1.asal = "Kingdom of Orvel";
	        //tidak ada variable umur, jadi dilakukan penambahan
	        p1.umur = 17;
	        p1.setJabatan("Assasin");
	        //Kesalahan Output print
	        //System.out.println("Nama Pegawai: " + p1.getNama());
	        System.out.println("Nama: " + p1.getNama());
	        System.out.println("Asal: " + p1.getAsal());
	        System.out.println("Jabatan: " + p1.jabatan);
	        //Kurangnya kata "Tahun" dalam print
	        //System.out.println("Umur: " + p1.umur);
	        System.out.println("Umur: " + p1.umur + " Tahun");
	    }
}