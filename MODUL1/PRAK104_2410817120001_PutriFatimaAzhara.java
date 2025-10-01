package MODUL1;

import java.util.Scanner;

public class PRAK104_2410817120001_PutriFatimaAzhara {

	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
	        
	        String[] abuInputs = new String[3];
	        String[] bagasInputs = new String[3];
	        
	        System.out.print("Tangan Abu: ");
	        for (int i = 0; i < 3; i++) {
	            abuInputs[i] = input.next();
	        }

	        System.out.print("Tangan Bagas: ");
	        for (int i = 0; i < 3; i++) {
	            bagasInputs[i] = input.next();
	        }

	        int skorAbu = 0;
	        int skorBagas = 0;

	        for (int i = 0; i < 3; i++) {
	            if (abuInputs[i].equals(bagasInputs[i])) {
	            } 
	            else if ((abuInputs[i].equals("B") && bagasInputs[i].equals("G")) ||
	                     (abuInputs[i].equals("G") && bagasInputs[i].equals("K")) ||
	                     (abuInputs[i].equals("K") && bagasInputs[i].equals("B"))) {
	                skorAbu++;
	            } 
	            else {
	                skorBagas++;
	            }
	        }

	        if (skorAbu > skorBagas) {
	            System.out.println("Abu");
	        } else if (skorBagas > skorAbu) {
	            System.out.println("Bagas");
	        } else {
	            System.out.println("Seri");
	        }
	        
	}

}