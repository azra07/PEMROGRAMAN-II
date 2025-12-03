package Impl;
import Dao.BukuDao;
import Model.Buku;
import Util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuImpl implements BukuDao {
    @Override
    public List<Buku> getAll() {
        List<Buku> list = new ArrayList<>();
        try (Connection c = DatabaseConnection.getConnection(); Statement s = c.createStatement(); ResultSet r = s.executeQuery("SELECT * FROM buku")) {
            while (r.next()) list.add(new Buku(r.getInt("buku_id"), r.getString("judul"), r.getString("penulis"), r.getInt("harga"), r.getInt("stok")));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
    @Override
    public void add(Buku b) {
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO buku (judul, penulis, harga, stok) VALUES (?,?,?,?)")) {
            ps.setString(1, b.getJudul()); ps.setString(2, b.getPenulis()); ps.setInt(3, b.getHarga()); ps.setInt(4, b.getStok());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public void edit(Buku b) {
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?")) {
            ps.setString(1, b.getJudul()); ps.setString(2, b.getPenulis()); ps.setInt(3, b.getHarga()); ps.setInt(4, b.getStok()); ps.setInt(5, b.getBuku_id());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public void delete(int id) {
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM buku WHERE buku_id=?")) {
            ps.setInt(1, id); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public Buku getById(int id) {
        Buku b = null;
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM buku WHERE buku_id=?")) {
            ps.setInt(1, id); ResultSet r = ps.executeQuery();
            if (r.next()) b = new Buku(r.getInt("buku_id"), r.getString("judul"), r.getString("penulis"), r.getInt("harga"), r.getInt("stok"));
        } catch (SQLException e) { e.printStackTrace(); }
        return b;
    }
    @Override
    public void kurangiStok(int id, int jumlah) {
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("UPDATE buku SET stok = stok - ? WHERE buku_id = ?")) {
            ps.setInt(1, jumlah); ps.setInt(2, id); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}