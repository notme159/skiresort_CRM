package model.component;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entity.Pokoj;
import model.entity.Zakaznik;
import model.entity.Strava;

public class TaMoZak extends AbstractTableModel {

    private List<AidZakInfo> zakInfa;
    private String[] header = {"zID", "Jméno:", "Přímení:", "Tel:", "Email:", "Ulice:",
        "Cp:", "Psc:", "Mesto:", "Příjezd:", "Odjezd:", "CelkCena:", "Penze:", "Strava:", "Internet:"};

    public TaMoZak(List<AidZakInfo> zakInfa) {
        this.zakInfa = zakInfa;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    public void update(List<AidZakInfo> zakInfa) {
        this.zakInfa = zakInfa;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return zakInfa.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (zakInfa != null) {

            Zakaznik z = zakInfa.get(rowIndex).getZak();
            Strava s = zakInfa.get(rowIndex).getStrav();
            Pokoj p = zakInfa.get(rowIndex).getPok();

            switch (columnIndex) {
                case 0:
                    return z.getZakaznik_id();
                case 1:
                    return z.getJmeno();
                case 2:
                    return z.getPrijmeni();
                case 3:
                    return z.getTelefon();
                case 4:
                    return z.getEmail();
//                case 5:
//                    return z.getAdresa().getAdresa_id();
                case 5:
                    return z.getAdresa().getUlice();
                case 6:
                    return z.getAdresa().getCp();
                case 7:
                    return z.getAdresa().getPsc().getPsc();
                case 8:
                    return z.getAdresa().getPsc().getMesto();
//                case 10:
//                    return z.getUbytovani().getUbytovani_id();
                case 9:
                    return z.getUbytovani().getDatum_prijezdu();
                case 10:
                    return z.getUbytovani().getDatum_odjezdu();
                case 11:
                    return z.getUbytovani().getCelkova_cena();
//                case 14:
//                    return s.getStrava_id();
                case 12:
                    return s.getTyp_penze();
                case 13:
                    return s.getTyp_stravy();
//                case 14:
//                    return s.getCena();
//                case 15:
//                    return p.getPokoj_id();
//                case 16:
//                    return p.getPocet_luzek();
                case 14:
                    return p.isInternet();
//                case 18:
//                    return p.getCena();
//                case 19:
//                    return p.isVolny();
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