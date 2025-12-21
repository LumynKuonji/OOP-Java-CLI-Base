package Backend.ticket;

public class ticketReguler extends ticket {
    private double hargaReguler;
    private int kapasitasReguler;
    private String status;

    public ticketReguler(String kategori, double harga, int kapasitas, String status) {
        super(kategori);
        this.hargaReguler = harga;
        this.kapasitasReguler = kapasitas;
        this.status = status;
    }

    @Override
    public double getHarga() {
        return hargaReguler;
    }

    @Override
    public int getKapasitas() {
        return kapasitasReguler;
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
