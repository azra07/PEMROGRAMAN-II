package MODUL1;

import java.util.Scanner;

public class PRAK101_2410817120001_PutriFatimaAzhara {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String nama, tempatLahir;
		int tanggalLahir, bulanLahir, tahunLahir;
		double tinggiBadan, beratBadan;
		
		String[] namaBulan = {"", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
		
		System.out.print("Masukkan Nama Lengkap: ");
		nama = input.nextLine();
		System.out.print("Masukkan Tempat Lahir: ");
		tempatLahir = input.nextLine();
		System.out.print("Masukkan Tanggal Lahir: ");
		tanggalLahir = input.nextInt();
		System.out.print("Masukkan Bulan Lahir: ");		bulanLahir = input.nextInt();
		System.out.print("Masukkan Tahun Lahir: ");
		tahunLahir = input.nextInt();
		System.out.print("Masukkan Tinggi Badan: ");
		tinggiBadan = input.nextDouble();
		System.out.print("Masukkan Berat Badan: ");
		beratBadan = input.nextDouble();
		
		System.out.printf("Nama Lengkap %s, Lahir di %s pada Tanggal %d %s %d Tinggi Badan %.0f cm dan Berat Badan %.2f kilogram", nama, tempatLahir, tanggalLahir, namaBulan[bulanLahir], tahunLahir, tinggiBadan, beratBadan);
	}
}