package Controller.Repo;

import Model.Ticket.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Database;

public class RepoTicket {

    public List<Ticket> TiketKonser(int idKonser) {

        List<Ticket> list = new ArrayList<>();

        String sql = """
                    SELECT t.id_tiket, k.nama_kategori,
                           t.harga_tiket, t.kapasitas_tiket, t.status_tiket
                    FROM tiket t
                    INNER JOIN konser p ON t.id_konser = p.id_konser
                    INNER JOIN kategori_tiket k ON t.id_kategori = k.id_kategori
                    WHERE p.id_konser = ?;
                """;

        try (Connection c = Database.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idKonser);
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                int idTiket = r.getInt("id_tiket");
                String kategori = r.getString("nama_kategori");
                double harga = r.getDouble("harga_tiket");
                int kapasitas = r.getInt("kapasitas_tiket");
                String status = r.getString("status_tiket");

                Ticket t = new Ticket(kategori, harga, kapasitas, status);

                t.setIdTiket(idTiket);
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean kurangiKapasitas(int idTiket, int jumlah) {

        String sql = """
                    UPDATE tiket
                    SET kapasitas_tiket = kapasitas_tiket - ?
                    WHERE id_tiket = ? AND kapasitas_tiket >= ?
                """;

        try (Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, jumlah);
            ps.setInt(2, idTiket);
            ps.setInt(3, jumlah);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}