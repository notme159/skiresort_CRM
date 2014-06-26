package model.entity;

public class Kategorie {
    private int kategorie_id;
    private String jmenoKategorie;

    public Kategorie() {
    }

    public Kategorie(int kategorie_id, String jmenoKategorie) {
        this.kategorie_id = kategorie_id;
        this.jmenoKategorie = jmenoKategorie;
    }

    public String getJmenoKategorie() {
        return jmenoKategorie;
    }

    public int getKategorie_id() {
        return kategorie_id;
    }

    public void setJmenoKategorie(String jmenoKategorie) {
        this.jmenoKategorie = jmenoKategorie;
    }

    public void setKategorie_id(int kategorie_id) {
        this.kategorie_id = kategorie_id;
    }
    
    
    
}
