package model.entity;

import java.sql.Date;
import model.entity.Zakaznik;

public class Vypujcka {
    private int vypujcka_id;
    private Date datum_vypujcky;
    private Date datum_vraceni;
    private double cena_k_zaplaceni;
    private Zakaznik zakaznik;
    private boolean vraceno_vcas;

    public Vypujcka() {
    }

    public Vypujcka(int vypujcka_id, Date datum_vypujcky, Date datum_vraceni, double cena_k_zaplaceni, Zakaznik zakaznik, boolean vraceno_vcas) {
        this.vypujcka_id = vypujcka_id;
        this.datum_vypujcky = datum_vypujcky;
        this.datum_vraceni = datum_vraceni;
        this.cena_k_zaplaceni = cena_k_zaplaceni;
        this.zakaznik = zakaznik;
        this.vraceno_vcas = vraceno_vcas;
    }

    public int getVypujcka_id() {
        return vypujcka_id;
    }

    public void setVypujcka_id(int vypujcka_id) {
        this.vypujcka_id = vypujcka_id;
    }

    public Date getDatum_vypujcky() {
        return datum_vypujcky;
    }

    public void setDatum_vypujcky(Date datum_vypujcky) {
        this.datum_vypujcky = datum_vypujcky;
    }

    public Date getDatum_vraceni() {
        return datum_vraceni;
    }

    public void setDatum_vraceni(Date datum_vraceni) {
        this.datum_vraceni = datum_vraceni;
    }

    public double getCena_k_zaplaceni() {
        return cena_k_zaplaceni;
    }

    public void setCena_k_zaplaceni(double cena_k_zaplaceni) {
        this.cena_k_zaplaceni = cena_k_zaplaceni;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public boolean isVraceno_vcas() {
        return vraceno_vcas;
    }

    public void setVraceno_vcas(boolean vraceno_vcas) {
        this.vraceno_vcas = vraceno_vcas;
    }   
}