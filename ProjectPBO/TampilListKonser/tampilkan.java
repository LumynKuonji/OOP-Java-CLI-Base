package TampilListKonser;

import Backend.Pengumuman.pengumuman;
import Backend.Pengumuman.repopengumuman;
import Backend.ticket.ticket;
import Backend.ticket.repoticket;

import java.util.List;

public class tampilkan {

    public void tampilkanSemuaKonser() {

        repopengumuman repoKonser = new repopengumuman();
        repoticket repoTiket = new repoticket();

        List<pengumuman> daftarKonser = repoKonser.getSemuaKonser();

        for (pengumuman konser : daftarKonser) {
            System.out.println("=================================");
            System.out.println("KONSER");
            System.out.println("---------------------------------");
            System.out.println("Nama   : " + konser.getNamaKonser());
            System.out.println("Artis  : " + konser.getArtis());
            System.out.println("Lokasi : " + konser.getLokasi());
            System.out.println("Tanggal: " + konser.getTanggal());
            System.out.println("Waktu  : " + konser.getWaktuMulai());

            List<ticket> daftarTiket = repoTiket.getTiketByKonser(konser.getIdKonser());

            System.out.println("\nTIKET TERSEDIA:");

            if (daftarTiket.isEmpty()) {
                System.out.println("- Tidak ada tiket tersedia");
            } else {
                for (ticket t : daftarTiket) {
                    System.out.println("---------------------------------");
                    System.out.println("Jenis     : " + t.getJenis());
                    System.out.println("Harga     : Rp " + t.getHarga());
                    System.out.println("Kapasitas : " + t.getKapasitas());
                    System.out.println("Status    : " + t.getStatus());
                }
            }

            System.out.println();
        }
    }
}

