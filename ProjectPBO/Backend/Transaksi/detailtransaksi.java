package Backend.Transaksi;

import java.time.LocalDate;

public class detailtransaksi extends transaksi {
    private int idDetail;
    private int idTiket;
    private int jumlahTiket;
    private double subtotal;

    public detailtransaksi(String metodePembayaran, LocalDate tanggalPesan, double totalBayar, int idTiket, int jumlahTiket, double subtotal) {
        super(metodePembayaran, tanggalPesan, totalBayar);
        this.idTiket = idTiket;
        this.jumlahTiket = jumlahTiket;
        this.subtotal = subtotal;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdDetail() {
        return idDetail;
    }
    public int getIdTiket() {
        return idTiket;
    }
    public int getJumlahTiket() {
        return jumlahTiket;
    }
    public double getSubtotal() {
        return subtotal;
    }
    
    @Override
    public void tampilkanInfoTransaksi() {
        super.tampilkanInfoTransaksi();
        System.out.println("ID Detail      : " + idDetail);
        System.out.println("ID Tiket       : " + idTiket);
        System.out.println("Jumlah Tiket   : " + jumlahTiket);
        System.out.println("Subtotal       : " + subtotal);
    }
}
