package Backend.Transaksi;

import java.time.LocalDate;
import Backend.User.user;

public class transaksi {
    protected int idTransaksi;
    protected int idUser;
    private String metodePembayaran;
    private LocalDate tanggalPesan;
    private double totalBayar;

    public transaksi(String metodePembayaran,
                     LocalDate tanggalPesan, double totalBayar) {
        this.metodePembayaran = metodePembayaran;
        this.tanggalPesan = LocalDate.now();
        this.totalBayar = totalBayar;
    }

    public void setIdUser(user user) {
        this.idUser = user.getIdUser();
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }
    public int getIdUser() {
        return idUser;
    }
    public String getMetodePembayaran() {
        return metodePembayaran;
    }
    public LocalDate getTanggalPesan() {
        return tanggalPesan;
    }
    public double getTotalBayar() {
        return totalBayar;
    }

    public void tampilkanInfoTransaksi() {
        System.out.println("ID Transaksi   : " + idTransaksi);
        System.out.println("ID User        : " + idUser);
        System.out.println("Metode Bayar   : " + metodePembayaran);
        System.out.println("Tanggal Pesan  : " + tanggalPesan);
        System.out.println("Total Bayar    : " + totalBayar);
    }
}
