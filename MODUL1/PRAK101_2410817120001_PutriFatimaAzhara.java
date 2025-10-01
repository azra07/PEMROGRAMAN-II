package MODUL1;

import java.util.Scanner;

public class PRAK101_2410817120001_PutriFatimaAzhara {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String nama, tempatLahir;
		int tanggalLahir, bulanLahir, tahunLahir;
		double tinggiBadan, beratBadan;
		
		String[] namaBulan = {"", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
		
		System.out.print("Masukkan Nama Lengkap: ");
		nama = scan.nextLine();
		System.out.print("Masukkan Tempat Lahir: ");
		tempatLahir = scan.nextLine();
		System.out.print("Masukkan Tanggal Lahir: ");
		tanggalLahir = scan.nextInt();
		System.out.print("Masukkan Bulan Lahir: ");		bulanLahir = scan.nextInt();
		System.out.print("Masukkan Tahun Lahir: ");
		tahunLahir = scan.nextInt();
		System.out.print("Masukkan Tinggi Badan: ");
		tinggiBadan = scan.nextDouble();
		System.out.print("Masukkan Berat Badan: ");
		beratBadan = scan.nextDouble();
		
		System.out.printf("Nama Lengkap %s, Lahir di %s pada Tanggal %d %s %d Tinggi Badan %.0f cm dan Berat Badan %.2f kilogram", nama, tempatLahir, tanggalLahir, namaBulan[bulanLahir], tahunLahir, tinggiBadan, beratBadan);
		
		scan.close();
	}
}