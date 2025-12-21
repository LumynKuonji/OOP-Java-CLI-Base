package Backend.Main;

// // import java.util.Scanner;
// // import Backend.Transaksi.*;
// // import Backend.User.user;
// // import Backend.ticket.*;
// // import TampilListKonser.tampilkan;

// // public class main {
// //     public static void main(String[] args) {

// //         System.out.println("=== Selamat Datang di Aplikasi Pemesanan Tiket Konser ===");
// //         System.out.println("Silakan login terlebih dahulu:");
// //         Scanner input = new Scanner(System.in);
// //         System.out.print("Masukkan nama: ");
// //         String nama = input.nextLine();
// //         System.out.print("Masukkan email: ");
// //         String email = input.nextLine();
// //         System.out.println("Masukkan no_telepon: ");
// //         String noTelp = input.nextLine();
// //         System.out.println("Halo, " + nama + "! Anda berhasil login dengan email " + email + " dengan nomor telepon " + noTelp + ".");
// //         user pengguna = new user(nama, email, noTelp);
// //         System.out.println("Berikut adalah daftar konser yang tersedia:");
// //         tampilkan tampil = new tampilkan();
// //         tampil.tampilkanSemuaKonser();

// //         Scanner scanner = new Scanner(System.in);
// //         System.out.print("Masukkan ID Konser yang ingin dipesan: ");
// //         int idKonser = scanner.nextInt();
// //         System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
// //         int jumlahTiket = scanner.nextInt();
// //         tiket tiketPesanan = new tiket(idKonser, jumlahTiket);
// //         double totalHarga = tiketPesanan.hitungTotalHarga();
// //     }
// // }

// package Backend.Main;

// import java.util.Scanner;
// import Backend.Transaksi.*;
// import Backend.User.user;
// import Backend.ticket.*;
// import TampilListKonser.tampilkan;

// public class main {
//     public static void main(String[] args) {

//         Scanner input = new Scanner(System.in);

//         System.out.println("=== Selamat Datang di Aplikasi Pemesanan Tiket Konser ===");
//         System.out.println("Silakan login terlebih dahulu:");

//         System.out.print("Masukkan nama: ");
//         String nama = input.nextLine();

//         System.out.print("Masukkan email: ");
//         String email = input.nextLine();

//         System.out.print("Masukkan no_telepon: ");
//         String noTelp = input.nextLine();

//         System.out.println("\nHalo, " + nama + "!");
//         System.out.println("Login berhasil.\n");

//         // objek user (tanpa input id)
//         user pengguna = new user(nama, email, noTelp);

//         // tampilkan konser
//         System.out.println("=== DAFTAR KONSER TERSEDIA ===");
//         tampilkan tampil = new tampilkan();
//         tampil.tampilkanSemuaKonser();

//         // pilih konser
//         System.out.print("\nMasukkan ID Konser yang ingin dipesan: ");
//         int idKonser = input.nextInt();

//         // tampilkan tiket berdasarkan konser
//         repoticket repoTiket = new repoticket();
//         System.out.println("\n=== DAFTAR TIKET ===");
//         for (ticket t : repoTiket.getTiketByKonser(idKonser)) {
//             System.out.println(
//                 t.getKategori() +
//                 " | Harga: " + t.getHarga() +
//                 " | Sisa: " + t.getKapasitas()
//             );
//         }

//         input.nextLine(); // clear buffer

//         // pilih kategori
//         System.out.print("\nPilih kategori tiket: ");
//         String kategori = input.nextLine();

//         System.out.print("Jumlah tiket: ");
//         int jumlah = input.nextInt();

//         // ambil tiket terpilih
//         ticket tiketDipilih = null;
//         for (ticket t : repoTiket.getTiketByKonser(idKonser)) {
//             if (t.getKategori().equalsIgnoreCase(kategori)) {
//                 tiketDipilih = t;
//                 break;
//             }
//         }

//         if (tiketDipilih == null) {
//             System.out.println("Kategori tiket tidak ditemukan.");
//             return;
//         }

//         double subtotal = tiketDipilih.getHarga() * jumlah;
//         System.out.println("Subtotal: " + subtotal);

//         input.nextLine();
//         System.out.print("Metode pembayaran (QRIS / Transfer / E-Wallet): ");
//         String metode = input.nextLine();

//         // === TRANSAKSI ===
//         transaksi trx = new transaksi(
//                 1, // id user (dummy / asumsi login)
//                 metode,
//                 subtotal
//         );

//         repotransaksi repoTrx = new repotransaksi();
//         int idTransaksi = repoTrx.insertTransaksi(trx);

//         // === DETAIL TRANSAKSI (INHERITANCE) ===
//         detailtransaksi detail = new detailtransaksi(
//                 trx.getIdUser(),
//                 trx.getMetodePembayaran(),
//                 trx.getTotalBayar(),
//                 tiketDipilih.getIdTiket(),
//                 jumlah,
//                 subtotal
//         );

//         detail.setIdTransaksi(idTransaksi);

//         repodetail repoDetail = new repodetail();
//         repoDetail.insertDetail(detail);

//         System.out.println("\n=== PEMESANAN BERHASIL ===");
//         System.out.println("ID Transaksi : " + idTransaksi);
//         System.out.println("Terima kasih telah memesan tiket 🎉");
//     }
// }

import Backend.Pengumuman.pengumuman;
import Backend.Pengumuman.repopengumuman;
import Backend.User.user;
import Backend.User.repouser;
import Backend.ticket.ticket;
import Backend.ticket.repoticket;
import Backend.Transaksi.transaksi;
import Backend.Transaksi.detailtransaksi;
import Backend.Transaksi.repotransaksi;
import Backend.Transaksi.repodetail;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ===============================
        // 1. TAMPILKAN LIST KONSER
        // ===============================
        repopengumuman repoKonser = new repopengumuman();
        List<pengumuman> konserList = repoKonser.getSemuaKonser();

        System.out.println("===== DAFTAR KONSER =====");

        for (int i = 0; i < konserList.size(); i++) {
            pengumuman k = konserList.get(i);
            System.out.println((i + 1) + ". " + k.getNamaKonser()
                    + " | " + k.getArtis()
                    + " | " + k.getTanggal());
        }

        System.out.print("\nPilih konser (nomor): ");
        int pilihKonser = input.nextInt() - 1;
        input.nextLine();

        pengumuman konserDipilih = konserList.get(pilihKonser);

        // ===============================
        // 2. TAMPILKAN TIKET
        // ===============================
        repoticket repoTiket = new repoticket();
        List<ticket> tiketList = repoTiket.getTiketByKonser(konserDipilih.getIdKonser());

        System.out.println("\n===== TIKET TERSEDIA =====");

        for (int i = 0; i < tiketList.size(); i++) {
            ticket t = tiketList.get(i);
            System.out.println((i + 1) + ". " + t.getJenis()
                    + " | Harga: Rp " + t.getHarga()
                    + " | Kapasitas: " + t.getKapasitas()
                    + " | Status: " + t.getStatus());
        }

        System.out.print("\nPilih tiket: ");
        int pilihTiket = input.nextInt() - 1;
        input.nextLine();

        ticket tiketDipilih = tiketList.get(pilihTiket);

        // ===============================
        // 3. JUMLAH TIKET
        // ===============================
        System.out.print("Jumlah tiket: ");
        int jumlah = input.nextInt();
        input.nextLine();

        double subtotal = tiketDipilih.getHarga() * jumlah;

        // ===============================
        // 4. INPUT DATA USER
        // ===============================
        System.out.println("\n===== DATA PEMESAN =====");

        System.out.print("Nama  : ");
        String nama = input.nextLine();

        System.out.print("Email : ");
        String email = input.nextLine();

        System.out.print("No Telp : ");
        String telp = input.nextLine();

        user u = new user(nama, email, telp);
        repouser repoUser = new repouser();
        repoUser.insertUser(u);

        // ===============================
        // 5. TRANSAKSI
        // ===============================
        System.out.print("\nMetode Pembayaran: ");
        String metode = input.nextLine();

        transaksi tr = new transaksi(metode, LocalDate.now(), subtotal);
        tr.setIdUser(u);

        repotransaksi repoTransaksi = new repotransaksi();
        repoTransaksi.insertTransaksi(tr);

        // ===============================
        // 6. DETAIL TRANSAKSI
        // ===============================
        detailtransaksi dt = new detailtransaksi(
                metode,
                LocalDate.now(),
                subtotal,
                pilihTiket + 1, // asumsi id_tiket
                jumlah,
                subtotal
        );

        dt.setIdTransaksi(tr.getIdTransaksi());

        repodetail repoDetail = new repodetail();
        repoDetail.insertDetail(dt);

        // ===============================
        // 7. OUTPUT TRANSAKSI
        // ===============================
        System.out.println("\n===== RINGKASAN TRANSAKSI =====");
        tr.tampilkanInfoTransaksi();

        System.out.println("\n===== DETAIL TRANSAKSI =====");
        dt.tampilkanInfoTransaksi();

        System.out.println("\n===== INFO TIKET =====");
        System.out.println("Konser : " + konserDipilih.getNamaKonser());
        System.out.println("Artis  : " + konserDipilih.getArtis());
        System.out.println("Jenis  : " + tiketDipilih.getJenis());
        System.out.println("Harga  : Rp " + tiketDipilih.getHarga());
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Total  : Rp " + subtotal);

        System.out.println("\nTerima kasih telah melakukan pemesanan 🎟️");
    }
}