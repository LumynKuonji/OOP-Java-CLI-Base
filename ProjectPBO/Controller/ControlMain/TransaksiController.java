package Controller.ControlMain;

import Controller.Repo.RepoTransaksi;
import Model.Transaksi.Transaksi;
import Model.User.User;
import View.Tampilkan;

import java.util.Scanner;

public class TransaksiController { // tC composite pController // tC dependency transaksi // tC dependency tampilkan // tC dependency user
    private PengumumanController pController = new PengumumanController();

    public void transaksiuser (Scanner input, Transaksi tr, Tampilkan view, User u){
        while (true){
            tr.setUser(u);
            pController.MilihKonser(input, tr, view);
            view.tampilanmetodePembayaran();
            int metode = input.nextInt();
            input.nextLine();
            tr.setMetode(metode);

            RepoTransaksi rTransaksi = new RepoTransaksi();
            rTransaksi.insertTransaksi(tr);
            tr.setDetail();

            view.ringkasanpesanan(tr);
            System.out.print("Ada transaksi lain? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("n")) 
                break;
        }
    }
}
