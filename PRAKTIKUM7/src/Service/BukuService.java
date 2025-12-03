package Service;
import java.util.List;
import Dao.BukuDao;
import Impl.BukuImpl;
import Model.Buku;

public class BukuService {
    private final BukuDao dao = new BukuImpl();

    public List<Buku> getAllBuku() { return dao.getAll(); }

    public void addBuku(Buku b) throws Exception {
        validasiData(b);
        dao.add(b);
    }
    public void editBuku(Buku b) throws Exception {
        if (b.getBuku_id() <= 0) throw new Exception("Pilih buku dulu!");
        validasiData(b);
        dao.edit(b);
    }
    public void deleteBuku(int id) throws Exception {
        if (id <= 0) throw new Exception("Pilih buku dulu!");
        dao.delete(id);
    }
    private void validasiData(Buku b) throws Exception {
        if (b.getJudul().isEmpty()) throw new Exception("Judul tidak boleh kosong!");
        if (b.getPenulis().isEmpty()) throw new Exception("Penulis tidak boleh kosong!");
        if (b.getHarga() <= 0) throw new Exception("Harga harus lebih dari 0!");
        if (b.getStok() < 0) throw new Exception("Stok tidak boleh minus!");
    }
}