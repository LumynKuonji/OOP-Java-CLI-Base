package Backend.ticket;

public class ticketVVIP extends ticket {
    private double hargaVVIP;
    private int kapasitasVVIP;
    private String status;

    public ticketVVIP(String kategori, double harga, int kapasitas, String status) {
        super(kategori);
        this.hargaVVIP = harga;
        this.kapasitasVVIP = kapasitas;
        this.status = status;
    }

    @Override
    public double getHarga() {
        return hargaVVIP;
    }

    @Override
    public int getKapasitas() {
        return kapasitasVVIP;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getJenis() {
        return super.getJenis();
    }
    @Override
    public String tampilInfo() {
        return "Konser : " + konser.getNamaKonser() +
                "\nArtis  : " + konser.getArtis() +
                "\nJenis  : " + getJenis() +
                "\nHarga  : Rp " + getHarga() +
                "\nKapasitas : " + getKapasitas() + "\nStatus : " + getStatus();
    }
}
