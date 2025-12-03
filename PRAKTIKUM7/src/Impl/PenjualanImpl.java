package Impl;
import Dao.PenjualanDao;
import Model.Penjualan;
import Util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanImpl implements PenjualanDao {
    @Override
    public List<Penjualan> getAll() {
        List<Penjualan> list = new ArrayList<>();
        String query = "SELECT p.*, pel.nama, b.judul " +
                       "FROM penjualan p " +
                       "JOIN pelanggan pel ON p.pelanggan_id = pel.pelanggan_id " +
                       "JOIN buku b ON p.buku_id = b.buku_id";
                       
        try (Connection c = DatabaseConnection.getConnection(); 
             Statement s = c.createStatement(); 
             ResultSet r = s.executeQuery(query)) {
            
            while (r.next()) {
                Penjualan p = new Penjualan(
                    r.getInt("penjualan_id"),
                    r.getInt("jumlah"),
                    r.getInt("total_harga"),
                    r.getDate("tanggal"),
                    r.getInt("pelanggan_id"),
                    r.getInt("buku_id")
                );
                
                p.setNamaPelanggan(r.getString("nama"));
                p.setJudulBuku(r.getString("judul"));
                
                list.add(p);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void add(Penjualan p) {
        String query = "INSERT INTO penjualan (pelanggan_id, buku_id, jumlah, total_harga, tanggal) VALUES (?,?,?,?, COALESCE(?, NOW()))";
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, p.getPelanggan_id());
            ps.setInt(2, p.getBuku_id());
            ps.setInt(3, p.getJumlah());
            ps.setInt(4, p.getTotal_harga());
            ps.setDate(5, p.getTanggal());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void edit(Penjualan p) {
        String query = "UPDATE penjualan SET pelanggan_id=?, buku_id=?, jumlah=?, total_harga=?, tanggal=? WHERE penjualan_id=?";
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, p.getPelanggan_id());
            ps.setInt(2, p.getBuku_id());
            ps.setInt(3, p.getJumlah());
            ps.setInt(4, p.getTotal_harga());
            ps.setDate(5, p.getTanggal());
            ps.setInt(6, p.getPenjualan_id());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM penjualan WHERE penjualan_id=?";
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}