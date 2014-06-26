package model.entity;

public class Strava {
    private int strava_id;
    private String typ_penze;
    private String typ_stravy;
    private Ubytovani ubytovani;
    private double cena;
    
    public Strava() {
    }

    public Strava(int strava_id, String typ_penze, String typ_stravy, Ubytovani ubytovani, double cena) {
        this.strava_id = strava_id;
        this.typ_penze = typ_penze;
        this.typ_stravy = typ_stravy;
        this.ubytovani = ubytovani;
        this.cena=cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
    public int getStrava_id() {
        return strava_id;
    }

    public void setStrava_id(int strava_id) {
        this.strava_id = strava_id;
    }

    public String getTyp_penze() {
        return typ_penze;
    }

    public void setTyp_penze(String typ_penze) {
        this.typ_penze = typ_penze;
    }

    public String getTyp_stravy() {
        return typ_stravy;
    }

    public void setTyp_stravy(String typ_stravy) {
        this.typ_stravy = typ_stravy;
    }

    public Ubytovani getUbytovani() {
        return ubytovani;
    }

    public void setUbytovani(Ubytovani ubytovani) {
        this.ubytovani = ubytovani;
    }

    @Override
    public String toString() {
        return strava_id+" " +typ_penze+" " +typ_stravy+" " +cena;
    }
}
