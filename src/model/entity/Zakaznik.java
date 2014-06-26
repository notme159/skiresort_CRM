package model.entity;

import model.entity.Adresa;


public class Zakaznik {
    private int zakaznik_id;
    private String jmeno;
    private String prijmeni;
    private String  telefon;
    private String email;
    private Adresa adresa;
    private Ubytovani ubytovani;
    

    public Zakaznik() {
    }

    public Zakaznik(int zakaznik_id, String jmeno, String prijmeni, String telefon, String email, Adresa adresa, Ubytovani ubytovani) {
        this.zakaznik_id = zakaznik_id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
        this.ubytovani = ubytovani;
    }
    
    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public Ubytovani getUbytovani() {
        return ubytovani;
    }

    public void setUbytovani(Ubytovani ubytovani) {
        this.ubytovani = ubytovani;
    }  
    
    public int getZakaznik_id() {
        return zakaznik_id;
    }

    public void setZakaznik_id(int zakaznik_id) {
        this.zakaznik_id = zakaznik_id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return zakaznik_id + " " + jmeno + " " + prijmeni + " " + telefon + " " + email;
    }
}
