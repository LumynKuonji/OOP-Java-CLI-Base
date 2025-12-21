package Backend.ticket;

public class ticketBackstage extends ticket {
    private double hargaBackstage;
    private int kapasitasBackstage;
    private String status;

    public ticketBackstage(String kategori, double harga, int kapasitas, String status) {
        super(kategori);
        this.hargaBackstage = harga;
        this.kapasitasBackstage = kapasitas;
        this.status = status;
    }

    @Override
    public double getHarga() {
        return hargaBackstage;
    }

    @Override
    public int getKapasitas() {
        return kapasitasBackstage;
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
