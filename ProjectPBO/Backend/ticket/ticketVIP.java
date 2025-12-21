package Backend.ticket;

public class ticketVIP extends ticket {
    private double hargaVIP;
    private int kapasitasVIP;
    private String status;

    public ticketVIP(String kategori, double harga, int kapasitas, String status) {
        super(kategori);
        this.hargaVIP = harga;
        this.kapasitasVIP = kapasitas;
        this.status = status;
    }

    @Override
    public double getHarga() {
        return hargaVIP;
    }

    @Override
    public int getKapasitas() {
        return kapasitasVIP;
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
