package model.component;

import java.util.List;
import javax.swing.AbstractListModel;

public class LiMoZak extends AbstractListModel<String> {

    List<AidZakInfo> zakaznici;

    public LiMoZak(List<AidZakInfo> zakaznici) {
        this.zakaznici = zakaznici;
    }

    @Override
    public int getSize() {
        return zakaznici.size();
    }

    @Override
    public String getElementAt(int i) {
        AidZakInfo z = zakaznici.get(i);
        return z.getZak().getZakaznik_id() + " " + z.getZak().getPrijmeni() + " " + z.getZak().getJmeno();
    }

    public void fireModelChanged() {
        fireIntervalAdded(this, 0, getSize() - 1);
    }
}