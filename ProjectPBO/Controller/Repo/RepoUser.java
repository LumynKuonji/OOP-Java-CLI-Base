package Controller.Repo;

import java.sql.*;
import Model.User.User;
import Database.Database;

public class RepoUser {

    public User SearchEmail(String email) {

        String sql = "SELECT * FROM user_akun WHERE email_user = ?";

        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet r = ps.executeQuery();

            if (r.next()) {
                return new User(
                        r.getInt("id_user"),
                        r.getString("nama_user"),
                        r.getString("email_user"),
                        r.getString("no_telp")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insertUser(User u) {

        String sql = """
            INSERT INTO user_akun (nama_user, email_user, no_telp)
            VALUES (?, ?, ?)
        """;

        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, u.getNamaUser());
            ps.setString(2, u.getEmailUser());   
            ps.setString(3, u.getNoTelp());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                u.setIdUser(id);
                return id;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
