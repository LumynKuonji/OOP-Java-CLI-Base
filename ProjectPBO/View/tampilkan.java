package View;

import java.util.List;

import Controller.Repo.repopengumuman;
import Controller.Repo.repoticket;
import Model.Pengumuman.pengumuman;
import Model.Transaksi.detailtransaksi;
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
        System.out.println("Ada diskon 40%, Apabila:\n1. Reguler berisi jumlah ticket >= 5\n2. VIP berisi jumlah ticket >= 4\n3. VVIP berisi jumlah ticket >= 3\n4. Backstage berisi jumlah ticket >= 2");
    }

    public void tampilanmetodePembayaran(){
        System.out.println("\n===== METODE PEMBAYARAN =====");
                System.out.println("1. Transfer Bank");
                System.out.println("2. E-Wallet");
                System.out.println("3. Kartu Kredit");
                System.out.println("4. Tunai");
                System.out.print("Pilih: ");
    }

    public void ringkasanpesanan(String nama, String email, List<detailtransaksi> detailList, double totalBayar, int idTransaksi){
        System.out.println("\n===== RINGKASAN PESANAN =====");
        System.out.println("Nama  : " + nama);
        System.out.println("Email : " + email);
        for (detailtransaksi d : detailList) {
            System.out.println("- Tiket ID : " + d.getIdTiket() +
            " | Jumlah : " + d.getJumlahTiket() +
            " | Subtotal : Rp " + (int) d.getSubtotal());
        }

        System.out.println("\nTOTAL BAYAR : Rp " + (int) totalBayar);
        System.out.println("ID TRANSAKSI : " + idTransaksi);
    }
}



