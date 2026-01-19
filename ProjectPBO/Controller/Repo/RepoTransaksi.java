package Controller.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Transaksi.*;
import Database.Database;

public class RepoTransaksi {

    public int insertTransaksi(Transaksi t) {

        String sql = """
            INSERT INTO transaksi (id_user, metode_pembayaran, total_bayar)
            VALUES (?, ?, ?)
        """;

        try (Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, t.getIdUser());
            ps.setString(2, t.getMetodePembayaran());
            ps.setDouble(3, t.getTotalBayar());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                t.setIdTransaksi(id);
                System.out.println("ID TRANSAKSI: " + id);
                return id;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
