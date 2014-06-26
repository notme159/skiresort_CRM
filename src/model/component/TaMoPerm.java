package model.component;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entity.Permanentka;
import model.entity.Zakaznik;

public class TaMoPerm extends AbstractTableModel {
    private String[] header = {"Jméno", "Příjmení", "Typ permanentky", "Cena"};
    private List<AidPermInfo> permInfo;

    public TaMoPerm(List<AidPermInfo> permInfo) {
        this.permInfo = permInfo;
    }
 
    @Override
    public int getRowCount() {
        return permInfo.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    public void update(List<AidPermInfo> permInfo) {
        this.permInfo = permInfo;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Permanentka p = permInfo.get(rowIndex).getPerm();
        Zakaznik z = permInfo.get(rowIndex).getZak();
        if (permInfo != null) {

            switch (columnIndex) {
                case 0:
                    return z.getJmeno();
                case 1:
                    return z.getPrijmeni();
                case 2:
                    return p.getTyp_permanentky();
                case 3:
                    return p.getCena();
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