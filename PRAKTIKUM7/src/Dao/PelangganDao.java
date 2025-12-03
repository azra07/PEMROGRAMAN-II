package Dao;
import java.util.List;
import Model.Pelanggan;

public interface PelangganDao {
    List<Pelanggan> getAll();
    void add(Pelanggan p);
    void edit(Pelanggan p);
    void delete(int id);
}