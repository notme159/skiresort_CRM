package model.component;

import model.entity.Permanentka;
import model.entity.Zakaznik;

public class AidPermInfo {
    private Permanentka perm;
    private Zakaznik zak;

    public AidPermInfo() {
    }

    public AidPermInfo(Permanentka perm, Zakaznik zak) {
        this.perm = perm;
        this.zak = zak;
    }

    public Permanentka getPerm() {
        return perm;
    }

    public Zakaznik getZak() {
        return zak;
    }

    public void setPerm(Permanentka perm) {
        this.perm = perm;
    }

    public void setZak(Zakaznik zak) {
        this.zak = zak;
    }
}