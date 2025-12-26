package View;

import java.util.List;

import Controller.Repo.repopengumuman;
import Controller.Repo.repoticket;
import Model.Pengumuman.pengumuman;
import Model.ticket.ticket;

public class tampilkan {
    public void tampilkanSemuaKonser() {
        repopengumuman repoKonser = new repopengumuman();
        List<pengumuman> daftarKonser = repoKonser.getSemuaKonser();

        System.out.println("=================================");
        System.out.println("DAFTAR KONSER");
        System.out.println("---------------------------------");
        int i = 1;
        for (pengumuman konser : daftarKonser) {
            System.out.println(i + ". Konser: ");
            System.out.println("Nama   : " + konser.getNamaKonser());
            System.out.println("Artis  : " + konser.getArtis());
            System.out.println("Lokasi : " + konser.getLokasi());
            System.out.println("Tanggal: " + konser.getTanggal());
            System.out.println("Waktu  : " + konser.getWaktuMulai());
            System.out.println("===============================");
            i++;
        }
    }

    public void tampilkanticketKonser (int id_konser){
        repoticket repoTiket = new repoticket();
        List<ticket> daftarTiket = repoTiket.TiketKonser(id_konser);
        int i = 1;
        System.out.println("\nTIKET TERSEDIA:");
        for (ticket t : daftarTiket){
            System.out.println("---------------------------------");
            System.out.println(i + ". Ticket");
            System.out.println("Kategori  : " + t.getKategori());
            System.out.printf("Harga     : Rp  %.2f%n",t.getHarga());
            System.out.println("Kapasitas : " + t.getKapasitas());
            System.out.println("Status    : " + t.getStatus());
            i++;
        }
    }
    
    public void PengumumanDiskon(){
        System.out.println("Ada diskon 40%, Apabila:\n1. Reguler berisi jumlah ticket: 5\n2. VIP berisi jumlah ticket: 4\n3. VVIP berisi jumlah ticket: 3\n4. Backstage berisi jumlah ticket: 2");
    }
}



