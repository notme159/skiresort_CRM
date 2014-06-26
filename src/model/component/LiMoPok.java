package model.component;

import java.util.List;
import javax.swing.AbstractListModel;
import model.entity.Pokoj;

public class LiMoPok extends  AbstractListModel<String> {
    
    private List<Pokoj> pokoje;
    
//    private int pocetLuzek = 2;
//    private boolean internet = true;
//    private boolean volny = true;
    
    public LiMoPok(List<Pokoj> pokoje) {
        this.pokoje = pokoje;
    }

    public void fireModelChanged() {
       // TODO kdyby se posral vyber pokoje
       // fireIntervalAdded(this, 0, getSize() - 1);
        fireIntervalRemoved(pokoje, 0, pokoje.size());
    }

    @Override
    public int getSize() {
        return pokoje.size();
    }

    @Override
    public String getElementAt(int i) {
        Pokoj p = pokoje.get(i);
//        if (pocetLuzek == p.getPocet_luzek() && volny == p.isVolny() && internet == p.isInternet()) {
            return p.getPokoj_id()+"     "+p.getPocet_luzek()+"     "+p.isInternet()+"     "+p.getCena()+"     "+p.isVolny();
//        }
//        
//        return "Obsazeno";
        
    }

//    public void setPocetLuzek(int pocetLuzek) {
//        this.pocetLuzek = pocetLuzek;
//    }
//
//    public void setInternet(boolean internet) {
//        this.internet = internet;
//    }
//
//    public void setVolny(boolean volny) {
//        this.volny = volny;
//    }
}