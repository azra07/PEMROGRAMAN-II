package MODUL1;

import java.util.Scanner;

public class PRAK104_2410817120001_PutriFatimaAzhara {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	        
	        String[] abuscans = new String[3];
	        String[] bagasscans = new String[3];
	        
	        System.out.print("Tangan Abu: ");
	        for (int i = 0; i < 3; i++) {
	            abuscans[i] = scan.next();
	        }

	        System.out.print("Tangan Bagas: ");
	        for (int i = 0; i < 3; i++) {
	            bagasscans[i] = scan.next();
	        }

	        int skorAbu = 0;
	        int skorBagas = 0;

	        for (int i = 0; i < 3; i++) {
	            if (abuscans[i].equals(bagasscans[i])) {
	            } 
	            else if ((abuscans[i].equals("B") && bagasscans[i].equals("G")) ||
	                     (abuscans[i].equals("G") && bagasscans[i].equals("K")) ||
	                     (abuscans[i].equals("K") && bagasscans[i].equals("B"))) {
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
	        scan.close();
	}

}