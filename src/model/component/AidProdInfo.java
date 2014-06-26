package model.component;

import model.entity.Kategorie;
import model.entity.Produkt;

public class AidProdInfo {
    private Produkt prod;
    private Kategorie kat;

    public AidProdInfo(Produkt prod, Kategorie kat) {
        this.prod = prod;
        this.kat = kat;
    }

    public Produkt getProd() {
        return prod;
    }

    public void setProd(Produkt prod) {
        this.prod = prod;
    }

    public Kategorie getKat() {
        return kat;
    }

    public void setKat(Kategorie kat) {
        this.kat = kat;
    }   
}