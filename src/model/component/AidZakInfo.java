package model.component;

import model.entity.Pokoj;
import model.entity.Strava;
import model.entity.Zakaznik;

public class AidZakInfo {

    private Zakaznik zak;
    private Strava strav;
    private Pokoj pok;

    public AidZakInfo(Zakaznik zak, Strava strav, Pokoj pok) {
        this.zak = zak;
        this.strav = strav;
        this.pok = pok;
    }

    public Zakaznik getZak() {
        return zak;
    }

    public void setZak(Zakaznik zak) {
        this.zak = zak;
    }

    public Strava getStrav() {
        return strav;
    }

    public void setStrav(Strava strav) {
        this.strav = strav;
    }

    public Pokoj getPok() {
        return pok;
    }

    public void setPok(Pokoj pok) {
        this.pok = pok;
    }
}