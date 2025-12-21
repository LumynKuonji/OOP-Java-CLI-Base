package Backend.Pengumuman;

public class pengumuman {
    private int idKonser;
    private String namaKonser;
    private String artis;
    private String lokasi;
    private String tanggal;
    private String waktuMulai;

    public pengumuman(int idKonser, String namaKonser, String artis,
                      String lokasi, String tanggal, String waktuMulai) {
        this.idKonser = idKonser;
        this.namaKonser = namaKonser;
        this.artis = artis;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.waktuMulai = waktuMulai;
    }
    public int getIdKonser() { return idKonser; }
    public String getNamaKonser() { return namaKonser; }
    public String getArtis() { return artis; }
    public String getLokasi() { return lokasi; }
    public String getTanggal() { return tanggal; }
    public String getWaktuMulai() { return waktuMulai; }
}
