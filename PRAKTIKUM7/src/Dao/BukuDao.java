package Dao;
import java.util.List;
import Model.Buku;

public interface BukuDao {
    List<Buku> getAll();
    void add(Buku b);
    void edit(Buku b);
    void delete(int id);
    Buku getById(int id);
    void kurangiStok(int id, int jumlah);
}