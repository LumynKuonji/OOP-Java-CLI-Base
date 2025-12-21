package Backend.ticket;
import Backend.Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class repoticket {

    public List<ticket> getTiketByKonser(int idKonser) {

        List<ticket> list = new ArrayList<>();

        String sql = """
            SELECT k.nama_kategori, t.harga_tiket, t.kapasitas_tiket, t.status_tiket
            FROM tiket t
            JOIN konser p ON t.id_konser = p.id_konser
            JOIN kategori_tiket k ON t.id_kategori = k.id_kategori
            WHERE p.id_konser = ?;
        """;

        try (Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idKonser);
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                String kategori = r.getString("nama_kategori");
                double harga = r.getDouble("harga_tiket");
                int kapasitas = r.getInt("kapasitas_tiket");
                String status = r.getString("status_tiket");

                ticket t = switch (kategori) {
                    case "Reguler" -> new ticketReguler(kategori, harga, kapasitas, status);
                    case "VIP" -> new ticketVIP(kategori, harga, kapasitas, status);
                    case "VVIP" -> new ticketVVIP(kategori, harga, kapasitas, status);
                    case "Backstage" -> new ticketBackstage(kategori, harga, kapasitas, status);
                    default -> new ticket(kategori);
                };

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}

