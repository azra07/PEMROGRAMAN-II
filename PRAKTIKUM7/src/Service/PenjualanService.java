package Service;
import java.util.List;
import Dao.BukuDao;
import Dao.PenjualanDao;
import Impl.BukuImpl;
import Impl.PenjualanImpl;
import Model.Buku;
import Model.Penjualan;

public class PenjualanService {
    private final PenjualanDao penjualanDao = new PenjualanImpl();
    private final BukuDao bukuDao = new BukuImpl();

    public List<Penjualan> getAllPenjualan() { return penjualanDao.getAll(); }

    public void addPenjualanAuto(Penjualan p) throws Exception {
        if (p.getPelanggan_id() <= 0) throw new Exception("Pilih Pelanggan!");
        if (p.getBuku_id() <= 0) throw new Exception("Pilih Buku!");
        if (p.getJumlah() <= 0) throw new Exception("Jumlah harus lebih dari 0!");

        Buku buku = bukuDao.getById(p.getBuku_id());
        if (buku.getStok() < p.getJumlah()) throw new Exception("Stok tidak cukup!");

        p.setTotal_harga(buku.getHarga() * p.getJumlah());
        penjualanDao.add(p);
        bukuDao.kurangiStok(p.getBuku_id(), p.getJumlah());
    }

    public void editPenjualan(Penjualan p) throws Exception {
        if (p.getPenjualan_id() <= 0) throw new Exception("Pilih transaksi!");
        penjualanDao.edit(p);
    }
    public void deletePenjualan(int id) throws Exception {
        if (id <= 0) throw new Exception("Pilih transaksi!");
        penjualanDao.delete(id);
    }
}