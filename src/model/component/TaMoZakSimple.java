package model.component;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entity.Zakaznik;

public class TaMoZakSimple extends AbstractTableModel {
    private List<Zakaznik> zakaznici;
    private String[] header = {"ZákId", "Jméno", "Příjm"};

    public TaMoZakSimple(List<Zakaznik> zakaznici) {
        this.zakaznici = zakaznici;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    public void update(List<Zakaznik> zakaznici) {
        this.zakaznici = zakaznici;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return zakaznici.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (zakaznici != null) {

            Zakaznik z = zakaznici.get(rowIndex);
            
            switch (columnIndex) {
                case 0:
                    return z.getZakaznik_id();
                case 1:
                    return z.getJmeno();
                case 2:
                    return z.getPrijmeni();
                default:
                    return "default";
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int sloupec) {
        return header[sloupec];
    }

    @Override
    public boolean isCellEditable(int radek, int sloupec) {
        return false;
    }
}