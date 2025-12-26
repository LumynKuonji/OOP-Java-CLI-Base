package Model.ticket;

public class ticketBackstage extends ticket {
    private double diskon = 0.4;
    private double subtotal;

    public ticketBackstage(String kategori, double harga, int kapasitas, String status) {
        super(kategori, harga,kapasitas,status);
    }

    @Override
    public double hitungSubtotal (int jumlah){
        if (jumlah >= 2){
            System.out.println("Selamat Mendapat diskon 40% dikarenakan memilih tiket >= 2");
            subtotal = ((1-diskon)*harga )* jumlah;
        }
        subtotal = harga * jumlah;
        return subtotal;
    }
}
