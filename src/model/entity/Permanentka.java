package model.entity;

import model.entity.Zakaznik;

public class Permanentka {
    private int permanentka_id;
    private double cena;
    private String typ_permanentky;
    private Zakaznik zakaznik;

    public Permanentka() {
    }

    public Permanentka(int permanentka_id, double cena, String typ_permanentky, Zakaznik zakaznik) {
        this.permanentka_id = permanentka_id;
        this.cena = cena;
        this.typ_permanentky = typ_permanentky;
        this.zakaznik = zakaznik;
    }

    public int getPermanentka_id() {
        return permanentka_id;
    }

    public void setPermanentka_id(int permanentka_id) {
        this.permanentka_id = permanentka_id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getTyp_permanentky() {
        return typ_permanentky;
    }

    public void setTyp_permanentka(String typ_permanentky) {
        this.typ_permanentky = typ_permanentky;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }
    
    
    
}
