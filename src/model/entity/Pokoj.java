package model.entity;

public class Pokoj {
    private int pokoj_id;
    private int pocet_luzek;
    private boolean internet;
    private Ubytovani ubytovani;
    private double cena;
    private boolean volny;

    public boolean isVolny() {
        return volny;
    }

    public void setVolny(boolean volny) {
        this.volny = volny;
    }
    
    public Pokoj() {
    }

    public Pokoj(int pokoj_id, int pocet_luzek, boolean internet, Ubytovani ubytovani, double cena, boolean volny) {
        this.pokoj_id = pokoj_id;
        this.pocet_luzek = pocet_luzek;
        this.internet = internet;
        this.ubytovani = ubytovani;
        this.cena = cena;
        this.volny=volny;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPokoj_id() {
        return pokoj_id;
    }

    public void setPokoj_id(int pokoj_id) {
        this.pokoj_id = pokoj_id;
    }

    public int getPocet_luzek() {
        return pocet_luzek;
    }

    public void setPocet_luzek(int pocet_luzek) {
        this.pocet_luzek = pocet_luzek;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public Ubytovani getUbytovani() {
        return ubytovani;
    }

    public void setUbytovani(Ubytovani ubytovani) {
        this.ubytovani = ubytovani;
    }
    
    
    
}
