package model.entity;

public class oldVypujcenyProdukt {
    private int mnozstvi;
    private Vypujcka vypujcka;
    private Produkt produkt;

    public oldVypujcenyProdukt() {
    }

    public oldVypujcenyProdukt(int mnozstvi, Vypujcka vypujcka, Produkt produkt) {
        this.mnozstvi = mnozstvi;
        this.vypujcka = vypujcka;
        this.produkt = produkt;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public void setMnozstvi(int mnozstvi) {
        this.mnozstvi = mnozstvi;
    }

    public Vypujcka getVypujcka() {
        return vypujcka;
    }

    public void setVypujcka(Vypujcka vypujcka) {
        this.vypujcka = vypujcka;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }
    
    
    
}
