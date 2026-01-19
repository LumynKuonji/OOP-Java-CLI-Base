package Controller.ControlMain;

import Controller.Repo.RepoUser;
import Model.User.User;

import java.util.Scanner;

public class UserController { // uC asosiasi dgn user // uC composite rUser
    private RepoUser rUser = new RepoUser();

    public User Login(Scanner input) {
        System.out.print("\nSudah punya akun? (sudah/belum): ");
        String pilihan = input.nextLine();

        User u = null;
        if (pilihan.equalsIgnoreCase("belum")) {
            System.out.println("===== REGISTER USER =====");
            System.out.print("Nama  : ");
            String nama = input.nextLine();
            System.out.print("Email : ");
            String email = input.nextLine().toLowerCase();
            System.out.print("Telp  : ");
            String noTelp = input.nextLine();

            u = new User(nama, email, noTelp);
            rUser.insertUser(u);

            System.out.println("User baru dibuat.");
            return u;
        }

        System.out.println("===== LOGIN USER =====");
        System.out.print("Email : ");
        String email = input.nextLine().toLowerCase();

        u = rUser.SearchEmail(email);

        if (u == null) {
            System.out.println("Email tidak ditemukan!");
            return null;
        }

        System.out.println("Selamat datang kembali, " + u.getNamaUser());
        return u;
    }
}
