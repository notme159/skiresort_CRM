package model.entity;

import java.util.Date;


public class Ubytovani {
    private int ubytovani_id;
    private Date datum_prijezdu;
    private Date datum_odjezdu;
    private double celkova_cena;
    
    

    public Ubytovani(int ubytovani_id, Date datum_prijezdu, Date datum_odjezdu, double celkova_cena) {
        this.ubytovani_id = ubytovani_id;
        this.datum_prijezdu = datum_prijezdu;
        this.datum_odjezdu = datum_odjezdu;
        this.celkova_cena=celkova_cena;
    }

    public double getCelkova_cena() {
        
        return celkova_cena;
    }

    public void setCelkova_cena(double celkova_cena) {
        this.celkova_cena = celkova_cena;
    }

    public int getUbytovani_id() {
        return ubytovani_id;
    }

    public void setUbytovani_id(int ubytovani_id) {
        this.ubytovani_id = ubytovani_id;
    }

    public Date getDatum_prijezdu() {
        return datum_prijezdu;
    }

    public void setDatum_prijezdu(Date datum_prijezdu) {
        this.datum_prijezdu = datum_prijezdu;
    }

    public Date getDatum_odjezdu() {
        return datum_odjezdu;
    }

    public void setDatum_odjezdu(Date datum_odjezdu) {
        this.datum_odjezdu = datum_odjezdu;
    }

    @Override
    public String toString() {
        return ubytovani_id + " " + datum_prijezdu + " " + datum_odjezdu + " " + celkova_cena;
    }
}
