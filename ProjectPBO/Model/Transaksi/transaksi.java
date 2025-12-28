package Model.Transaksi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.User.user;

public class transaksi {

    private int idTransaksi;
    private int idUser;
    private String metodePembayaran;
    private LocalDate tanggalPesan;
    private double totalBayar;
    private List<detailtransaksi> detailList;

    public transaksi() {
        this.tanggalPesan = LocalDate.now();
        this.detailList = new ArrayList<>();
        this.totalBayar = 0;
    }

    public void setMetode(int pilihMetode){
        this.metodePembayaran = switch (pilihMetode) {
            case 1 -> "Transfer Bank";
            case 2 -> "E-Wallet";
            case 3 -> "Kartu Kredit";
            case 4 -> "Tunai";
            default -> "Transfer Bank";
        };
    }

    public void setIdUser(user user) {
        this.idUser = user.getIdUser();
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void tambahDetail(detailtransaksi detail) {
        detailList.add(detail);
        totalBayar += detail.getSubtotal();
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

    public List<detailtransaksi> getDetailList() {
        return detailList;
    }

    public void tampilkanInfoTransaksi() {
        System.out.println("ID Transaksi  : " + idTransaksi);
        System.out.println("ID User       : " + idUser);
        System.out.println("Metode Bayar  : " + metodePembayaran);
        System.out.println("Tanggal Pesan : " + tanggalPesan);
        System.out.println("Total Bayar   : Rp " + (int) totalBayar);
    }
}
