package View;

import java.util.List;

import Controller.Repo.RepoPengumuman;
import Controller.Repo.RepoTicket;
import Model.Pengumuman.Pengumuman;
import Model.Transaksi.*;
import Model.Ticket.Ticket;

public class Tampilkan {
    public void tampilkanSemuaKonser() {
        RepoPengumuman repoKonser = new RepoPengumuman();
        List<Pengumuman> daftarKonser = repoKonser.getSemuaKonser();

        System.out.println("=================================");
        System.out.println("DAFTAR KONSER");
        System.out.println("---------------------------------");
        int i = 1;
        for (Pengumuman konser : daftarKonser) {
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
        RepoTicket rTiket = new RepoTicket();
        List<Ticket> daftarTiket = rTiket.TiketKonser(id_konser);
        int i = 1;
        System.out.println("\nTIKET TERSEDIA:");
        for (Ticket t : daftarTiket){
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

    public void ringkasanpesanan(Transaksi tr){
        System.out.println("\n===== RINGKASAN PESANAN =====");
        System.out.println("Nama  : " + tr.getNama());
        System.out.println("Email : " + tr.getEmail());
        for (DetailTransaksi d : tr.getDetailList()) {
            System.out.println("- Tiket ID : " + d.getIdTiket() +
            " | Jumlah : " + d.getJumlahTiket() +
            " | Subtotal : Rp " + (int) d.getSubtotal());
        }

        System.out.println("\nTOTAL BAYAR : Rp " + (int) tr.getTotalBayar());
        System.out.println("ID TRANSAKSI : " + tr.getIdTransaksi());
    }
}



