package Model.ticket;

public class ticketVVIP extends ticket {
    private double diskon = 0.4;
    private double subtotal;

    public ticketVVIP(String kategori, double harga, int kapasitas, String status) {
        super(kategori, harga,kapasitas,status);
    }

    @Override
    public double hitungSubtotal (int jumlah){
        if (jumlah >= 3){
            System.out.println("Selamat Mendapat diskon 40% dikarenakan memilih tiket >= 3");
            subtotal = ((1-diskon)*harga )* jumlah;
        }
        subtotal = harga * jumlah;
        return subtotal;
    }
}
