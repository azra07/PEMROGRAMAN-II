package soal2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih jenis hewan yang ingin diinputkan: ");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilih = input.nextInt();
        input.nextLine();
        if (pilih != 1 && pilih != 2) {
            throw new IllegalArgumentException("Pilihan hanya 1 dan 2");
        } else {
            dataHewanPeliharaan(pilih, input);
        }
    }
    
    static private void dataHewanPeliharaan(int pilih, Scanner input){
        System.out.print("Nama hewan peliharaan: ");
        String nama = input.nextLine();
        System.out.print("Ras: ");
        String ras = input.nextLine();
        System.out.print("Warna bulu: ");
        String warnaBulu = input.nextLine();
        if (pilih == 1) {
            Kucing kucing = new Kucing(ras, nama, warnaBulu);
            kucing.displayDetailKucing();
        } else if (pilih == 2) {
            System.out.print("Memiliki kemampuan: ");
            String kemampuanList = input.nextLine();
            String[] kemampuan = kemampuanList.split(", ");
            Anjing anjing = new Anjing(ras, nama, warnaBulu, kemampuan);
            anjing.displayDetailAnjing();
        }
    }
}