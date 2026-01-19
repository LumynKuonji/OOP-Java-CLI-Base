package Controller.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Transaksi.*;

import Database.Database;

public class RepoDetail { 

    public int insertDetail(DetailTransaksi d) {

        String sql = """
            INSERT INTO detail_transaksi (id_transaksi, id_tiket, jumlah_tiket, subtotal)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, d.getIdTransaksi());
            ps.setInt(2, d.getIdTiket());
            ps.setInt(3, d.getJumlahTiket());
            ps.setDouble(4, d.getSubtotal());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                d.setIdDetail(id);
                System.out.println("ID DETAIL TRANSAKSI: " + id);
                return id;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
