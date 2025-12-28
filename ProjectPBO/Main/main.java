package Main;

import Controller.Repo.repodetail;
import Controller.Repo.repopengumuman;
import Controller.Repo.repoticket;
import Controller.Repo.repotransaksi;
import Controller.Repo.repouser;

import Model.Pengumuman.pengumuman;
import Model.Transaksi.detailtransaksi;
import Model.Transaksi.transaksi;
import Model.User.user;
import Model.ticket.ticket;
import Model.ticket.ticketReguler;
import Model.ticket.ticketVIP;
import Model.ticket.ticketVVIP;
import Model.ticket.ticketBackstage;
import View.tampilkan;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true){
            System.out.print("\nMau login ? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("===== LOGIN USER =====");
            System.out.print("Nama  : ");
            String nama = input.nextLine();
            System.out.print("Email : ");
            String email = input.nextLine();
            System.out.print("Telp  : ");
            String telp = input.nextLine();

            repouser rUser = new repouser();
            user u = rUser.SearchEmail(email);

            if (u == null) {
                u = new user(nama, email, telp);
                rUser.insertUser(u);
                System.out.println("User baru dibuat.");
            } else {
                System.out.println("Selamat datang kembali, " + u.getNamaUser());
            }

            repopengumuman rKonser = new repopengumuman();
            repoticket rTiket = new repoticket();

            List<pengumuman> konserList = rKonser.getSemuaKonser();
            tampilkan view = new tampilkan();

            while (true){
                transaksi tr = new transaksi();
                tr.setIdUser(u);
                while (true) {
                    double subtotal = 0;
                    view.tampilkanSemuaKonser();

                    System.out.print("Pilih konser: ");
                    int pilihKonser = input.nextInt();
                    input.nextLine();

                    pengumuman konserDipilih = null;
                    for (pengumuman k : konserList) {
                        if (k.getIdKonser() == pilihKonser) {
                            konserDipilih = k;
                            break;
                        }
                    }
                    if (konserDipilih == null) {
                        System.out.println("Konser tidak ditemukan!");
                        continue;
                    }

                    while (true) {
                        List<ticket> ticketList = rTiket.TiketKonser(pilihKonser);
                        view.tampilkanticketKonser(pilihKonser);
                        view.PengumumanDiskon();
                        System.out.print("Pilih tiket: ");
                        int pilihTiket = input.nextInt() - 1;
                        System.out.print("Jumlah: ");
                        int jumlah = input.nextInt();
                        input.nextLine();

                        ticket t = ticketList.get(pilihTiket);

                        if (jumlah > t.getKapasitas()) {
                            System.out.println("Stok tidak mencukupi!");
                            continue;
                        }

                        rTiket.kurangiKapasitas(t.getIdTiket(), jumlah);

                        if (t.getKategori().equalsIgnoreCase("Reguler")) {
                            ticketReguler k = new ticketReguler(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
                            subtotal = k.hitungSubtotal(jumlah);
                        }
                        else if (t.getKategori().equalsIgnoreCase("VIP")) {
                            ticketVIP k = new ticketVIP(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
                            subtotal = k.hitungSubtotal(jumlah);
                        }
                        else if (t.getKategori().equalsIgnoreCase("VVIP")) {
                            ticketVVIP k = new ticketVVIP(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
                            subtotal = k.hitungSubtotal(jumlah);
                        }
                        else {
                            ticketBackstage k = new ticketBackstage(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
                            subtotal = k.hitungSubtotal(jumlah);
                        }

                        detailtransaksi dt = new detailtransaksi(
                                t.getIdTiket(),
                                jumlah,
                                subtotal
                        );
                        tr.tambahDetail(dt);

                        System.out.print("Tambah tiket lain? (y/n): ");
                        if (input.nextLine().equalsIgnoreCase("n")) break;
                    }

                    System.out.print("Tambah konser lain? (y/n): ");
                    if (input.nextLine().equalsIgnoreCase("n")) break;
                }
                view.tampilanmetodePembayaran();
                int metode = input.nextInt();
                input.nextLine();
                tr.setMetode(metode);

                repotransaksi repoTransaksi = new repotransaksi();
                int idTransaksi = repoTransaksi.insertTransaksi(tr);

                repodetail repoDetail = new repodetail();
                for (detailtransaksi d : tr.getDetailList()) {
                    d.setIdTransaksi(idTransaksi);
                    repoDetail.insertDetail(d);
                }

                view.ringkasanpesanan(nama, email, tr.getDetailList(), tr.getTotalBayar(), tr.getIdTransaksi());
                System.out.print("\nTransaksi baru? (y/n): ");
                if (input.nextLine().equalsIgnoreCase("n")) {
                    break;
                } 
            }
            System.out.print("\nLogout or Exit ? (L/E): ");
            if (input.nextLine().equalsIgnoreCase("E")) {
                break;
            }
        }
        
    }
}
