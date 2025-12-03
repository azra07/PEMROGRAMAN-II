package Dao;
import java.util.List;
import Model.Penjualan;

public interface PenjualanDao {
    List<Penjualan> getAll();
    void add(Penjualan p);
    void edit(Penjualan p);
    void delete(int id);
}