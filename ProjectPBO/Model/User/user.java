package Model.User;

public class user {
    private int idUser;
    private String namaUser;
    private String emailUser;
    private String noTelp;

    public user(String namaUser, String emailUser, String noTelp) {
        this.namaUser = namaUser;
        this.emailUser = emailUser;
        this.noTelp = noTelp;
    }
    
    public user(int idUser, String namaUser, String emailUser, String noTelp) {
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.emailUser = emailUser;
        this.noTelp = noTelp;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void tampilkanInfoUser() {
        System.out.println("ID User   : " + idUser);
        System.out.println("Nama      : " + namaUser);
        System.out.println("Email     : " + emailUser);
        System.out.println("No Telp   : " + noTelp);
    }
}
