package model.component;

import model.entity.Vypujcka;
import model.entity.Zakaznik;

public class AidVypInfo {
    private Zakaznik zak;
    private Vypujcka vyp;

    public AidVypInfo(Zakaznik zak, Vypujcka vyp) {
        this.zak = zak;
        this.vyp = vyp;
    }

    public Zakaznik getZak() {
        return zak;
    }

    public void setZak(Zakaznik zak) {
        this.zak = zak;
    }

    public Vypujcka getVyp() {
        return vyp;
    }

    public void setVyp(Vypujcka vyp) {
        this.vyp = vyp;
    }
}