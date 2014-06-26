package model.component;

import java.util.List;
import javax.swing.AbstractListModel;
import model.entity.Produkt;

public class LiMoProd extends AbstractListModel<String> {
    
    private List<Produkt> produkty;

    public LiMoProd(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    @Override
    public int getSize() {
        return produkty.size();
    }

    @Override
    public String getElementAt(int i) {
        Produkt p = produkty.get(i);
        String produkt = p.getProdukt_id() + " " + p.getKategorie().getJmenoKategorie() + " "
                + p.getJmeno_produktu() + " " + p.getVelikost() + " " + p.getCena() + "kč " + p.isPujceno();
        return produkt;
    }
    
    public void fireModelChanged() {
        fireIntervalAdded(this, 0, getSize()-1);
    }
}