package Backend.ticket;

import Backend.Pengumuman.pengumuman;

public class ticket {
    protected pengumuman konser;
    private String kategori;
    private double harga;
    private int kapasitas_tiket;
    private String status_ticket;

    public ticket(String kategori) {
        this.kategori = kategori;
    }

    public void setharga(double harga){
        this.harga=harga;
    }

    public void setKapasitas(int Kapasitas){
        this.kapasitas_tiket=Kapasitas;
    }
    public void setStatus(String status){
        this.status_ticket=status;
    }
    public double getHarga(){
        return harga;
    }
    public int getKapasitas(){
        return kapasitas_tiket;
    }
    public String getStatus(){
        return status_ticket;
    }
    public String getJenis() {
        return kategori;
    }

    public String tampilInfo() {
        return "Konser : " + konser.getNamaKonser() +
                "\nArtis  : " + konser.getArtis() +
                "\nJenis  : " + getJenis() +
                "\nHarga  : Rp " + getHarga() +
                "\nKapasitas : " + getKapasitas() + "\nStatus : " + getStatus();
    }
}
