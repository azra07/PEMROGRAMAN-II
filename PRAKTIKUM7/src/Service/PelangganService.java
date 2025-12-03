package Service;
import java.util.List;
import Dao.PelangganDao;
import Impl.PelangganImpl;
import Model.Pelanggan;

public class PelangganService {
    private final PelangganDao dao = new PelangganImpl();

    public List<Pelanggan> getAllPelanggan() { return dao.getAll(); }

    public void addPelanggan(Pelanggan p) throws Exception {
        validasiData(p);
        dao.add(p);
    }
    public void editPelanggan(Pelanggan p) throws Exception {
        if (p.getPelanggan_id() <= 0) throw new Exception("Pilih data dulu!");
        validasiData(p);
        dao.edit(p);
    }
    public void deletePelanggan(int id) throws Exception {
        if (id <= 0) throw new Exception("Pilih data dulu!");
        dao.delete(id);
    }
    private void validasiData(Pelanggan p) throws Exception {
        if (p.getNama() == null || p.getNama().trim().isEmpty()) throw new Exception("Nama tidak boleh kosong!");
        if (p.getEmail() == null || p.getEmail().trim().isEmpty()) throw new Exception("Email tidak boleh kosong!");
        if (!p.getEmail().contains("@")) throw new Exception("Email harus pakai @!");
        if (p.getTelepon() == null || p.getTelepon().trim().isEmpty()) throw new Exception("Telepon tidak boleh kosong!");
    }
}