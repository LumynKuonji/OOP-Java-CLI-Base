package Model.Transaksi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Controller.Repo.RepoDetail;
import Model.User.User;

public class Transaksi {
    private int idTransaksi;
    private int idUser;
    private String namaUser;
    private String emailUser;
    private String metodePembayaran;
    private LocalDate tanggalPesan;
    private double totalBayar;
    private double diskonvoucher;
    private List<DetailTransaksi> detailList;
    private DetailTransaksi detail;

    public Transaksi() {
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

    public void setDetail(){
        RepoDetail rDetail = new RepoDetail();
        for (DetailTransaksi d : getDetailList()) {
            d.setIdTransaksi(idTransaksi);
            rDetail.insertDetail(d);
        }
    }

    public void setUser(User u) {
        this.idUser = u.getIdUser();
        this.namaUser = u.getNamaUser();
        this.emailUser = u.getEmailUser();
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void tambahDetail(int idtiket, int jumlahTiket, double subtotal) {
        detail = new DetailTransaksi(idtiket, jumlahTiket, subtotal);
        detailList.add(detail);
        totalBayar += detail.getSubtotal();
    }

    public void setVoucher(String kode){
        if (kode.equalsIgnoreCase("OPEN2026")) {
            this.diskonvoucher = 0.10;
            System.out.println("Selamat mendapat diskon" + (diskonvoucher*100) + "%");
        } else if (kode.equalsIgnoreCase("NEWYEAR")) {
            this.diskonvoucher = 0.15;
            System.out.println("Selamat mendapat diskon" + (diskonvoucher*100) + "%");
        } else {
            this.diskonvoucher = 0;
            System.out.println("Maaf salah input atau coba lagi");
        }
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

    public List<DetailTransaksi> getDetailList() {
        return detailList;
    }

    public String getNama(){
        return namaUser;
    }

    public String getEmail(){
        return emailUser;
    }

    public double getDiskon(){
        return diskonvoucher;
    }
}
