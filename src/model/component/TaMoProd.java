package model.component;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entity.Kategorie;
import model.entity.Produkt;

public class TaMoProd extends AbstractTableModel {

    private List<AidProdInfo> prodInfa;
    private String[] header = {"Produkt ID", "Název", "Velikost", "Cena", "Půjčeno", "Kategorie"};

    public TaMoProd(List<AidProdInfo> prodInfa) {
        this.prodInfa = prodInfa;
    }

    @Override
    public int getRowCount() {
        return prodInfa.size();
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

    public void update(List<AidProdInfo> prodInfa) {
        this.prodInfa = prodInfa;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (prodInfa != null) {

            Produkt p = prodInfa.get(rowIndex).getProd();
            Kategorie k = prodInfa.get(rowIndex).getKat();

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
                    return k.getJmenoKategorie();
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