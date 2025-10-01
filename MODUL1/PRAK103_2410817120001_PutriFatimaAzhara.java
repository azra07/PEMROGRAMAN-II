package MODUL1;

import java.util.Scanner;

public class PRAK103_2410817120001_PutriFatimaAzhara {

	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
        
        System.out.print("");
        int nilaiN = scan.nextInt();
        int bilanganAwal = scan.nextInt();
        
        int i = 0;
        int j = bilanganAwal;

        do {
            if (j % 2 != 0) {
                System.out.printf("%d", j);
                
                if (i < nilaiN - 1) {
                    System.out.printf(", ");
                }
                i++;
            }
            j++;
        } while (i < nilaiN);

        scan.close();
	}

}