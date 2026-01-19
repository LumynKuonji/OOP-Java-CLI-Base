package Main;

import Controller.ControlMain.TransaksiController;
import Controller.ControlMain.UserController;
import Model.User.User;
import Model.Transaksi.Transaksi;
import View.Tampilkan;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserController uC = new UserController();
        TransaksiController tC = new TransaksiController();
        Tampilkan view = new Tampilkan();
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("\nMau login ? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("n")) 
                break;
            User u = uC.Login(input);
            Transaksi tr = new Transaksi();
            System.out.print("Ada kode voucher akhir tahun? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("y")){
                System.out.print("Input kode: ");
                String kode = input.nextLine();
                tr.setVoucher(kode);
            }
            tC.transaksiuser(input, tr, view, u);
            System.out.print("\nMau Logout atau Exit ? (L/E): ");
            if (input.nextLine().equalsIgnoreCase("E"))
                break;
        }

    }
 
}

