package eletegloss.src;
import java.math.BigDecimal;


public class Paket {

    // ─── Attribute ───────────────────────────────────────────────────────────────
    private int aid;                 // Primärschlüssel (AUTO_INCREMENT in DB)
    private int kid;                 // Kunde-ID (Fremdschlüssel)
    private int pid;                 // Paket-ID  (Fremdschlüssel)

    private String vname;            // Vorname
    private String nname;            // Nachname
    private String emailAdresse;     // E-Mail

    private String pname;            // Paketname
    private BigDecimal preis;        // Preis decimal(10,2)
    private String zusatzleistung;   // kann NULL sein

    // ─── Konstruktoren ───────────────────────────────────────────────────────────
    /** Leerer Standardkonstruktor (wird z. B. von vielen Frameworks verlangt) */
    public Paket() {
        
    }

    /** Voller Konstruktor, falls Du alle Felder selbst setzen willst */
    public Paket(int aid, int kid, int pid,
                 String vname, String nname, String emailAdresse,
                 String pname, BigDecimal preis, String zusatzleistung) {
        this.aid             = aid;
        this.kid             = kid;
        this.pid             = pid;
        this.vname           = vname;
        this.nname           = nname;
        this.emailAdresse    = emailAdresse;
        this.pname           = pname;
        this.preis           = preis;
        this.zusatzleistung  = zusatzleistung;
    }

    // ─── Getter & Setter ─────────────────────────────────────────────────────────
    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getKid() {
        return kid;
    }
    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getVname() {
        return vname;
    }
    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getNname() {
        return nname;
    }
    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }
    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getPreis() {
        return preis;
    }
    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public String getZusatzleistung() {
        return zusatzleistung;
    }
    public void setZusatzleistung(String zusatzleistung) {
        this.zusatzleistung = zusatzleistung;
    }

    // ─── toString (praktisch zum Ausgeben in der Konsole) ────────────────────────
    @Override
    public String toString() {
        return "Paket{" +
               "aid=" + aid +
               ", kid=" + kid +
               ", pid=" + pid +
               ", vname='" + vname + '\'' +
               ", nname='" + nname + '\'' +
               ", emailAdresse='" + emailAdresse + '\'' +
               ", pname='" + pname + '\'' +
               ", preis=" + preis +
               ", zusatzleistung='" + zusatzleistung + '\'' +
               '}';
    }
}
