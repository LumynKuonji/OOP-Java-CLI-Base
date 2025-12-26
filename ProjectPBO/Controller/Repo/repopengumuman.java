package Controller.Repo;

import java.sql.*;
import java.util.ArrayList;
import Database.Database;
import Model.Pengumuman.*;

public class repopengumuman {

    public ArrayList<pengumuman> getSemuaKonser() {
        ArrayList<pengumuman> list = new ArrayList<>();

        String sql = "SELECT * FROM konser";

        try (Connection c = Database.getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery(sql)) {

            while (r.next()) {
                pengumuman p = new pengumuman(
                    r.getInt("id_konser"),
                    r.getString("nama_konser"),
                    r.getString("artis"),
                    r.getString("lokasi"),
                    r.getDate("tanggal").toString(),
                    r.getTime("waktu_mulai").toString()
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
