package Model.Ticket;

public class TicketReguler extends Ticket {
    private double subtotal;

    public TicketReguler(String kategori, double harga, int kapasitas, String status) {
        super(kategori,harga,kapasitas,status);
    }

    @Override
    public double hitungSubtotal (int jumlah){
        if (jumlah >= 5){
            System.out.println("Selamat Mendapat diskon 40% dikarenakan memilih tiket >= 5");
            subtotal = ((1-diskon)*harga )* jumlah;
            return subtotal;
        }
        subtotal = harga * jumlah;
        return subtotal;
    }
    @Override
    public double hitungSubtotal (int jumlah, double diskontambahan){
        if (jumlah >= 5){
            System.out.println("Selamat Mendapat diskon "+ ((diskon+diskontambahan)*100) +"% dikarenakan memilih tiket >= 5");
            subtotal = ((1-(diskon+diskontambahan))*harga )* jumlah;
            return subtotal;
        }
        System.out.println("Selamat mendapatkan diskon dari penukaran kode voucher diskon " + (diskontambahan*100) +"%");
        subtotal = ((1-diskontambahan)*harga )* jumlah;
        return subtotal;
    }
}
