package Model.ticket;

public class ticket {
    protected int idTiket;
    protected double harga;
    protected int kapasitas;
    protected String status;
    protected String kategori;
    protected double diskon = 0.4;

    public ticket(String kategori, double harga, int kapasitas, String status) {
        this.kategori = kategori;
        this.harga = harga;
        this.kapasitas = kapasitas;
        this.status = status;
    }

    public double hitungSubtotal(int jumlah){
        return harga * jumlah;
    }
    public void setIdTiket(int idTiket) { 
        this.idTiket = idTiket;
    }
    public String getKategori() { 
        return kategori; 
    }
    public int getIdTiket() { 
        return idTiket; 
    }
    public double getHarga() { 
        return harga; 
    }
    public int getKapasitas() { 
        return kapasitas; 
    }
    public String getStatus() { 
        return status; 
    }

}
