package Controller.ControlMain;

import Controller.Repo.RepoPengumuman;
import Model.Pengumuman.Pengumuman;
import Model.Transaksi.Transaksi;
import View.Tampilkan;

import java.util.List;
import java.util.Scanner;

public class PengumumanController { // pC composite rPengumu, tC // pC dependency tr, view
    private RepoPengumuman rPengumu = new RepoPengumuman();
    private TicketController tiC = new TicketController();

    public void MilihKonser (Scanner input, Transaksi tr, Tampilkan view){
        while (true){
            List<Pengumuman> konserList = rPengumu.getSemuaKonser();
            view.tampilkanSemuaKonser();

            System.out.print("Pilih konser: ");
            int pilihKonser = input.nextInt();
            input.nextLine();
            int konserDipilih = 0;
            for (Pengumuman p : konserList) {
                if (p.getIdKonser() == pilihKonser) {
                    konserDipilih = p.getIdKonser();
                    tiC.prosesPemesanan(input, tr, view, konserDipilih);
                }
            }
            if (konserDipilih == 0){
                System.out.println("Konser tidak ditemukan");
            }
            System.out.print("Tambah konser lain? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("n")) 
                break;
        }
    }
}

