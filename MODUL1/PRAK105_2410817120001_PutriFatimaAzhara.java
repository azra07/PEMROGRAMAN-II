package MODUL1;

import java.util.Scanner;

public class PRAK105_2410817120001_PutriFatimaAzhara {

	public static void main(String[] args) {
		final double PHI = 3.14;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Masukkan jari-jari: ");
        double jariJari = scan.nextDouble();
        
        System.out.print("Masukkan tinggi: ");
        double tinggi = scan.nextDouble();
        
        if (jariJari <= 0 || tinggi <= 0) {
            System.out.println("Input tidak valid! Jari-jari dan tinggi harus lebih dari 0.");
        } else {
            double volume = PHI * jariJari * jariJari * tinggi;
            System.out.printf("Volume tabung dengan jari-jari %.1f cm dan%n", jariJari);
            System.out.printf("tinggi %.1f cm adalah %.3f m3%n", tinggi, volume);
        }
        scan.close();
	}

}