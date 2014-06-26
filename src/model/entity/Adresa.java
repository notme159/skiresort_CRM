package model.entity;

public class Adresa {
    private int adresa_id;
    private String ulice;
    private int cp;
    private Psc psc;

    public Adresa(int adresa_id, String ulice, int cp, Psc psc) {
        this.adresa_id = adresa_id;
        this.ulice = ulice;
        this.cp = cp;
        this.psc = psc;
    }
    
    public Adresa(String ulice, int cp, Psc psc) {
        this.ulice = ulice;
        this.cp = cp;
        this.psc = psc;
    }

    public int getAdresa_id() {
        return adresa_id;
    }

    public void setAdresa_id(int adresa_id) {
        this.adresa_id = adresa_id;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Psc getPsc() {
        return psc;
    }

    public void setPsc(Psc psc) {
        this.psc = psc;
    }

    @Override
    public String toString() {
        return adresa_id + " " + ulice + " " + cp + " " + psc;
    }
    
    
    
}
