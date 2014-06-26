package model.entity;

public class Psc {
    private String psc;
    private String mesto;

    public Psc(String psc, String mesto) {
        this.psc = psc;
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public String getMesto() {
        return mesto;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return psc + " " + mesto;
    }
    
 
}
