package model.component;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entity.Kategorie;
import model.entity.Produkt;

public class maybeLaterTaMoProdSimple extends AbstractTableModel {

    private List<Produkt> produkty;
    private String[] header = {"Produkt ID", "Název", "Velikost", "Cena", "Půjčeno", "Kategorie"};

    public maybeLaterTaMoProdSimple(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public maybeLaterTaMoProdSimple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return produkty.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void update(List<Produkt> produkty) {
        this.produkty = produkty;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (produkty != null) {

            Produkt p = produkty.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return p.getProdukt_id();
                case 1:
                    return p.getJmeno_produktu();
                case 2:
                    return p.getVelikost();
                case 3:
                    return p.getCena();
                case 4:
                    return p.isPujceno();
                case 5:
                    return p.getKategorie().getJmenoKategorie();
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