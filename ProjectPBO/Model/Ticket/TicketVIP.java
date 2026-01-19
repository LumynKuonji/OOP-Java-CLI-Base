package Model.Ticket;

public class TicketVIP extends Ticket {
    private double subtotal;

    public TicketVIP(String kategori, double harga, int kapasitas, String status) {
        super(kategori, harga,kapasitas,status);
    }

    @Override
    public double hitungSubtotal (int jumlah){
        if (jumlah >= 4){
            System.out.println("Selamat Mendapat diskon 40% dikarenakan memilih tiket >= 4");
            subtotal = ((1-diskon)*harga )* jumlah;
            return subtotal;
        }
        subtotal = harga * jumlah;
        return subtotal;
    }
    @Override
    public double hitungSubtotal (int jumlah, double diskontambahan){
        if (jumlah >= 4){
            System.out.println("Selamat Mendapat diskon "+ ((diskon+diskontambahan)*100) +"% dikarenakan memilih tiket >= 4");
            subtotal = ((1-(diskon+diskontambahan))*harga )* jumlah;
            return subtotal;
        }
        System.out.println("Selamat mendapatkan diskon dari penukaran kode voucher diskon " + (diskontambahan*100) +"%");
        subtotal = ((1-diskontambahan)*harga )* jumlah;
        return subtotal;
    }
}
