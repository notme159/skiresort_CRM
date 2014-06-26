package model.entity;

public class Produkt {
    private int produkt_id;
    private String jmeno_produktu;
    private int velikost;
    private double cena;
    private boolean pujceno;
    private Kategorie kategorie;

    public Produkt() {
    }

    public Produkt(int produkt_id, String jmeno_produktu, int velikost, double cena, boolean pujceno, Kategorie kategorie) {
        this.produkt_id = produkt_id;
        this.jmeno_produktu = jmeno_produktu;
        this.velikost = velikost;
        this.cena = cena;
        this.pujceno = pujceno;
        this.kategorie = kategorie;
    }

    public int getProdukt_id() {
        return produkt_id;
    }

    public void setProdukt_id(int produkt_id) {
        this.produkt_id = produkt_id;
    }

    public String getJmeno_produktu() {
        return jmeno_produktu;
    }

    public void setJmeno_produktu(String jmeno_produktu) {
        this.jmeno_produktu = jmeno_produktu;
    }

    public int getVelikost() {
        return velikost;
    }

    public void setVelikost(int velikost) {
        this.velikost = velikost;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public boolean isPujceno() {
        return pujceno;
    }

    public void setPujceno(boolean pujceno) {
        this.pujceno = pujceno;
    }
    
}
