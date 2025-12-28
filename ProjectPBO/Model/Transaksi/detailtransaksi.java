package Model.Transaksi;

public class detailtransaksi {

    private int idDetail;
    private int idTransaksi;
    private int idTiket;
    private int jumlahTiket;
    private double subtotal;

    public detailtransaksi(int idTiket, int jumlahTiket, double subtotal) {
        this.idTiket = idTiket;
        this.jumlahTiket = jumlahTiket;
        this.subtotal = 0;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public int getIdTransaksi() {
        return idTransaksi;
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
}
