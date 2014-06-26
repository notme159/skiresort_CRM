package model.component;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entity.Vypujcka;
import model.entity.Zakaznik;

public class TaMoZakVyp extends AbstractTableModel {

    private List<AidVypInfo> vypInfa;
    private String[] header = {"Zákazník ID:", "Jméno:", "Příjmení", "Výpůjčka ID:", "Půjčeno:", "Vrátit:", "Vráceno Včas:", "Cena:"};

    public TaMoZakVyp(List<AidVypInfo> vypInfa) {
        this.vypInfa = vypInfa;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    public void update(List<AidVypInfo> vypInfa) {
        this.vypInfa = vypInfa;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return vypInfa.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    @Override
    public String getColumnName(int sloupec) {
        return header[sloupec];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (vypInfa != null) {
            
            Vypujcka v = vypInfa.get(rowIndex).getVyp();
            Zakaznik z = vypInfa.get(rowIndex).getZak();

            switch (columnIndex) {
                case 0:
                    return z.getZakaznik_id();
                case 1:
                    return z.getJmeno();
                case 2:
                    return z.getPrijmeni();
                case 3:
                    return v.getVypujcka_id();
                case 4:
                    return v.getDatum_vypujcky();
                case 5:
                    return v.getDatum_vraceni();
                case 6:
                    return v.isVraceno_vcas();
                case 7:
                    return v.getCena_k_zaplaceni();
            }
        }
        return null;
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
}
