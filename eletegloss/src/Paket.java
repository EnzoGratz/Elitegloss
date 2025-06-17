package eletegloss.src;

import java.math.BigDecimal;

public class Paket {

    //Attribute
    private String vname;
    private String nname;
    private String telnr;

    private String paketName;
    private BigDecimal preis;
    private String zusatzleistung;
    private String zahlung;

    //Konstruktoren 
    public Paket() {}

    public Paket(String vname, String nname, String telnr,
                 String paketName, BigDecimal preis, String zusatzleistung, String zahlung) {
        this.vname           = vname;
        this.nname           = nname;
        this.telnr           = telnr;
        this.paketName       = paketName;
        this.preis           = preis;
        this.zusatzleistung  = zusatzleistung;
        this.zahlung         = zahlung;
    }

    //Getter & Setter
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

    public String getTelnr() {
        return telnr;
    }
    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }

    public String getPaketName() {
        return paketName;
    }
    public void setPaketName(String paketName) {
        this.paketName = paketName;
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
    

    public String getZahlung() {
        return zahlung;
    }

    public void setZahlung(String zahlung) {
        this.zahlung = zahlung;
    }

    //toString
    @Override
    public String toString() {
        return "Paket{" +
                ", vname='" + vname + '\'' +
                ", nname='" + nname + '\'' +
                ", telnr='" + telnr + '\'' +
                ", paketName='" + paketName + '\'' +
                ", preis=" + preis +
                ", zusatzleistung='" + zusatzleistung + '\'' +
                ", zahlung='" + zahlung + '\'' +
                '}';
    }
}
