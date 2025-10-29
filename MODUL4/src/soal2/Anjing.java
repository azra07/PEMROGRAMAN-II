package soal2;

public class Anjing extends HewanPeliharaan {
    private String warnaBulu;
    private String[] kemampuan;
    public Anjing(String n, String r, String w, String[] k) {
        super(n, r);
        this.warnaBulu = w;
        this.kemampuan = k;
    }
    public void displayDetailAnjing() {
        super.display();
        System.out.println("Warna bulu: " + this.warnaBulu);
        System.out.print("Memiliki kemampuan: ");
        for (String i : kemampuan) {
            System.out.print(i + " ");
        }
    }
}