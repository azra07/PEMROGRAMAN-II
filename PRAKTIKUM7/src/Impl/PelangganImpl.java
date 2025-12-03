package Impl;
import Dao.PelangganDao;
import Model.Pelanggan;
import Util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganImpl implements PelangganDao {
    @Override
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = new ArrayList<>();
        try (Connection c = DatabaseConnection.getConnection(); Statement s = c.createStatement(); ResultSet r = s.executeQuery("SELECT * FROM pelanggan")) {
            while (r.next()) list.add(new Pelanggan(r.getInt("pelanggan_id"), r.getString("nama"), r.getString("email"), r.getString("telepon")));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
    @Override
    public void add(Pelanggan p) {
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO pelanggan (nama, email, telepon) VALUES (?,?,?)")) {
            ps.setString(1, p.getNama()); ps.setString(2, p.getEmail()); ps.setString(3, p.getTelepon());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public void edit(Pelanggan p) {
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?")) {
            ps.setString(1, p.getNama()); ps.setString(2, p.getEmail()); ps.setString(3, p.getTelepon()); ps.setInt(4, p.getPelanggan_id());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public void delete(int id) {
        try (Connection c = DatabaseConnection.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM pelanggan WHERE pelanggan_id=?")) {
            ps.setInt(1, id); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}