package Backend.User;

import Backend.Database.Database;
import java.sql.*;

public class repouser {

    public int insertUser(user u) {

        String sql = """
            INSERT INTO user_akun (nama_user, email_user, no_telp)
            VALUES (?, ?, ?)
        """;

        try (Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, u.getNamaUser());
            ps.setString(2, u.getEmailUser());
            ps.setString(3, u.getNoTelp());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                u.setIdUser(id);
                System.out.println("ID USER: " + id);
                return id;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
