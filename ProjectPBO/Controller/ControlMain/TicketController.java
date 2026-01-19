package Controller.ControlMain;

import Controller.Repo.RepoTicket;
import Model.Transaksi.Transaksi;
import Model.Ticket.*;
import View.Tampilkan;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TicketController { // tiC dependency ticket // tiC komposisi rTiket // tiC dependency transaksi, view
    private RepoTicket rTiket = new RepoTicket();

    public void prosesPemesanan(Scanner input, Transaksi tr, Tampilkan view, int idKonser) {

        while (true) {
            List<Ticket> ticketList = rTiket.TiketKonser(idKonser);
            if (ticketList == null || ticketList.isEmpty()) {
                System.out.println("Tidak ada tiket tersedia untuk konser ini.");
                return;
            }

            view.tampilkanticketKonser(idKonser);
            view.PengumumanDiskon();

            int pilihTiket = -1;
            boolean inputValid = false;
            while (!inputValid) {
                try {
                    System.out.print("Pilih tiket (1-" + ticketList.size() + "): ");
                    int nomor = input.nextInt();
                    pilihTiket = nomor - 1; 

                    if (pilihTiket >= 0 && pilihTiket < ticketList.size()) {
                        inputValid = true;
                    } else {
                        System.out.println("Pilihan harus antara 1-" + ticketList.size());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Harus berupa angka!");
                    input.nextLine(); 
                }
            }

            int jumlah = 0;
            inputValid = false;
            while (!inputValid) {
                try {
                    System.out.print("Jumlah tiket: ");
                    jumlah = input.nextInt();
                    if (jumlah > 0) {
                        inputValid = true;
                    } else {
                        System.out.println("Jumlah harus lebih dari 0!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Harus berupa angka!");
                    input.nextLine();
                }
            }
            input.nextLine();

            Ticket t = ticketList.get(pilihTiket);

            if (jumlah > t.getKapasitas()) {
                System.out.println("Stok tidak mencukupi!");
                continue;
            }

            rTiket.kurangiKapasitas(t.getIdTiket(), jumlah);

            double subtotal = hitungSubtotal(t, jumlah, tr);

            tr.tambahDetail(t.getIdTiket(), jumlah, subtotal);

            System.out.print("Tambah tiket lain? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("n")) 
                break;
        }
    }

    private double hitungSubtotal(Ticket t, int jumlah, Transaksi tr) {

        if (t.getKategori().equalsIgnoreCase("Reguler")) {
            t = new TicketReguler(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
        }
        else if (t.getKategori().equalsIgnoreCase("VIP")) {
            t = new TicketVIP(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
        }
        else if (t.getKategori().equalsIgnoreCase("VVIP")) {
            t = new TicketVVIP(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
        }
        else {
            t = new TicketBackstage(t.getKategori(), t.getHarga(), t.getKapasitas(), t.getStatus());
        }

        if (tr.getDiskon() > 0){
            return t.hitungSubtotal(jumlah, tr.getDiskon());
        }
        else{
            return t.hitungSubtotal(jumlah);
        }
    }
}
