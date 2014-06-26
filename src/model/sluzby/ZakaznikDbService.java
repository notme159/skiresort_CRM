package model.sluzby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.component.AidPermInfo;
import model.component.AidProdInfo;
import model.component.AidVypInfo;
import model.component.AidZakInfo;
import model.entity.Adresa;
import model.entity.Psc;
import model.entity.Zakaznik;
import model.entity.Pokoj;
import model.entity.Strava;
import model.entity.Ubytovani;
import model.entity.Kategorie;
import model.entity.Permanentka;
import model.entity.Produkt;
import model.entity.Vypujcka;

public class ZakaznikDbService implements IntZakaznikService {

    private Connection conn;
    private List<Zakaznik> zakaznici;
    private List<Pokoj> pokoje;
    private List<Strava> stravy;
    private List<AidZakInfo> zakInfa;
    private List<Produkt> produkty;
    private List<Kategorie> kategorie;
    private List<AidProdInfo> prodInfa;
    private List<AidPermInfo> permInfa;
    private List<AidVypInfo> vypInfa;
    private boolean vracenoVcas;
    private List<Integer> productIds;

    public ZakaznikDbService() {

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:data/skiresort", "randoms", "");

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "chyba pripojeni k dtb");
        }

    }

    @Override
    public List<AidZakInfo> prehledZak() {

        zakaznici = new ArrayList<>();
        pokoje = new ArrayList<>();
        stravy = new ArrayList<>();
        zakInfa = new ArrayList<>();

        String query =
                "SELECT z.zakaznik_id, z.jmeno, z.prijmeni, z.telefon, z.email, z.adresa_adresa_id, z.ubytovani_ubytovani_id, a.adresa_id, a.ulice, a.cp, a.psc_psc,\n"
                + "                        p.psc, p.mesto, u.ubytovani_id, u.datum_prijezdu, u.datum_odjezdu, u.celkova_cena, s.strava_id, s.typ_penze, s.typ_stravy, s.ubytovani_ubytovani_id, s.cena,\n"
                + "                        p.pokoj_id, p.pocet_luzek, p.internet, p.ubytovani_ubytovani_id, p.cena, p.volny\n"
                + "                        FROM\n"
                + "                        Skiresort.Psc p JOIN Skiresort.adresa a ON p.psc=a.psc_psc\n"
                + "                        JOIN Skiresort.zakaznik z ON a.adresa_id = z.adresa_adresa_id\n"
                + "                        JOIN Skiresort.ubytovani u ON u.ubytovani_id = z.ubytovani_ubytovani_id\n"
                + "                        JOIN Skiresort.strava s ON u.ubytovani_id = s.ubytovani_ubytovani_id\n"
                + "                        JOIN Skiresort.pokoj p on p.ubytovani_ubytovani_id = u.ubytovani_id";

        Statement stm = null;
        try {
            stm = conn.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chyba pri tvorbe statementu");
        }
        ResultSet rs = null;
        try {
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chyba pri execute query");
        }
        try {
            while (rs.next()) {

                Psc psc = new Psc(rs.getString("psc"), rs.getString("mesto"));
                Adresa adr = new Adresa(rs.getInt("adresa_id"), rs.getString("ulice"), rs.getInt("cp"), psc);
                Ubytovani ubyt = new Ubytovani(rs.getInt("ubytovani_id"), rs.getDate("datum_prijezdu"), rs.getDate("datum_odjezdu"), rs.getDouble("celkova_cena"));
                Zakaznik z = new Zakaznik(rs.getInt("zakaznik_id"), rs.getString("jmeno"), rs.getString("prijmeni"), rs.getString("telefon"), rs.getString("email"), adr, ubyt);
                Pokoj p = new Pokoj(rs.getInt("pokoj_id"), rs.getInt("pocet_luzek"), rs.getBoolean("internet"), ubyt, rs.getDouble("cena"), rs.getBoolean("volny"));
                Strava s = new Strava(rs.getInt("strava_id"), rs.getString("typ_penze"), rs.getString("typ_stravy"), ubyt, rs.getDouble("cena"));

                zakaznici.add(z);
                stravy.add(s);
                pokoje.add(p);

                zakInfa.add(new AidZakInfo(z, s, p));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chyba pri tahani z rs");
        }

        return zakInfa;
    }

    @Override
    public List<AidProdInfo> getProdukty() {

        produkty = new ArrayList<>();
        kategorie = new ArrayList<>();
        prodInfa = new ArrayList<>();

        try {
            if (conn != null) {
                String query = "SELECT p.PRODUKT_ID , p.JMENO_PRODUKTU , p.VELIKOST , p.CENA, p.PUJCENO, p.KATEGORIE_KATEGORIE_ID , k.KATEGORIE_ID , k.JMENO_KATEGORIE\n"
                        + "FROM SKIRESORT.PRODUKT p JOIN SKIRESORT.KATEGORIE k ON p.KATEGORIE_KATEGORIE_ID = k.KATEGORIE_ID";

                try (Statement stm = conn.createStatement();) {
                    ResultSet rs = stm.executeQuery(query);
                    while (rs.next()) {

                        Kategorie k = new Kategorie(rs.getInt("kategorie_id"), rs.getString("jmeno_kategorie"));
                        Produkt p = new Produkt(rs.getInt("produkt_id"), rs.getString("jmeno_produktu"), rs.getInt("velikost"), rs.getDouble("cena"), rs.getBoolean("pujceno"), k);

                        produkty.add(p);
                        kategorie.add(k);
                        prodInfa.add(new AidProdInfo(p, k));
                    }

                } catch (Exception ex) {
                }
            }
        } catch (Exception ex) {
            System.out.println("selhal select produkty");
        }

        return prodInfa;


    }

    @Override
    public void pridatZak(String[] zakInfo) {
        try {
            Ubytovani ubyt;
            Psc psc;
            Adresa adr;
            Zakaznik zak;
            Strava strav;

            // PSC
            String queryPsc = "insert into skiresort.psc (psc,mesto) values (?,?)";
            PreparedStatement stm = conn.prepareStatement(queryPsc);
            stm.setString(1, zakInfo[6].toString()); // psc
            stm.setString(2, zakInfo[7].toString()); // mesto
            stm.execute();

            psc = new Psc(zakInfo[6].toString(), zakInfo[7].toString());

            System.out.println("psc: " + psc);
            stm.close();
            // /PSC

            // ADRESA
            String queryAdr = "insert into skiresort.adresa (ulice,cp,psc_psc) values (?,?,?)";
            stm = conn.prepareStatement(queryAdr, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, zakInfo[4].toString()); // ulice
            stm.setString(2, zakInfo[5].toString()); // cp
            stm.setString(3, psc.getPsc()); // psc ref
            stm.execute();

            ResultSet generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            adr = new Adresa(generatedKeys.getInt(1), zakInfo[4].toString(), Integer.parseInt(zakInfo[5].toString()), psc);

            System.out.println("adr: " + adr);
            stm.close();
            // /ADRESA

            // UBYT
            String queryUbyt = "insert into skiresort.ubytovani (datum_prijezdu,datum_odjezdu,celkova_cena) values (default,?,?)";
            stm = conn.prepareStatement(queryUbyt, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, zakInfo[9].toString()); // odj
            stm.setString(2, zakInfo[18].toString());// celková cena
            stm.execute();

            generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();

            Date datePrij = new SimpleDateFormat("yyyy-MM-dd").parse(zakInfo[8]);
            Date dateOdj = new SimpleDateFormat("yyyy-MM-dd").parse(zakInfo[9]);
            System.out.println(zakInfo[18]);
            double celkovaCena = Double.parseDouble(zakInfo[18]);

            ubyt = new Ubytovani(generatedKeys.getInt(1), datePrij, dateOdj, celkovaCena);
            System.out.println("ubyt: " + ubyt);
            stm.close();
            // /UBYT

            // ZAK
            String queryZak = "insert into skiresort.zakaznik (jmeno,prijmeni,telefon,email,adresa_adresa_id,ubytovani_ubytovani_id) values (?,?,?,?,?,?)";
            stm = conn.prepareStatement(queryZak, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, zakInfo[0].toString()); // jmeno
            stm.setString(2, zakInfo[1].toString()); // prijmeni
            stm.setString(3, zakInfo[2].toString()); // tel
            stm.setString(4, zakInfo[3].toString()); // email
            stm.setInt(5, adr.getAdresa_id());
            stm.setInt(6, ubyt.getUbytovani_id());
            stm.execute();

            generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            zak = new Zakaznik(generatedKeys.getInt(1), zakInfo[0].toString(), zakInfo[1].toString(), zakInfo[2].toString(), zakInfo[3].toString(), adr, ubyt);

            System.out.println("zak: " + zak);
            stm.close();
            // /ZAK

            // STRAVA
            String queryStra = "insert into skiresort.strava (typ_penze,typ_stravy,ubytovani_ubytovani_id,cena) values (?,?,?,?)";
            stm = conn.prepareStatement(queryStra, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, zakInfo[10]);//penze
            stm.setString(2, zakInfo[11]);//typStravy
            stm.setInt(3, ubyt.getUbytovani_id());
            stm.setDouble(4, Double.valueOf(zakInfo[12]));//cenaStravy
            stm.execute();

            generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            strav = new Strava(generatedKeys.getInt(1), zakInfo[10], zakInfo[11], ubyt, Double.valueOf(zakInfo[12]));

            System.out.println("str: " + strav);
            stm.close();
            // /STRAVA

            // POKOJ
            String queryPok = "update skiresort.pokoj SET ubytovani_ubytovani_id=?, volny=false WHERE pokoj_id=?";
            stm = conn.prepareStatement(queryPok);
            stm.setInt(1, ubyt.getUbytovani_id());
            stm.setInt(2, Integer.parseInt(zakInfo[13].trim()));//pokojId
            stm.executeUpdate();
            stm.close();
            // /POKOJ

        } catch (SQLException | ParseException ex) {
            System.out.println("fail v pridatZak(String[] zakInfo) sql bo parse ex");
        }
    }

    @Override
    public List<Pokoj> getPokoje() {
        pokoje = new ArrayList<>();
        try {
            if (conn != null) {
                // TODO: poresit lepsi query :s
                String queryPokoj = "SELECT * FROM skiresort.pokoj";
                try (Statement stm = conn.createStatement();) {
                    ResultSet rs = stm.executeQuery(queryPokoj);
                    while (rs.next()) {

                        Pokoj p = new Pokoj(rs.getInt("pokoj_id"), rs.getInt("pocet_luzek"), rs.getBoolean("internet"), null, rs.getDouble("cena"), rs.getBoolean("volny"));

                        pokoje.add(p);
                    }
                } catch (Exception ex) {
                    System.out.println("chyba v getPokoje()");
                }
            }
        } catch (Exception ex) {
            System.out.println("selhal select produkty");
        }
        return pokoje;
    }

    @Override
    public void odstrZak(int zakId) {
        System.out.println("uz to vola odstrZak v dbservice");

        // int ubytId;
        int pokojId;

        try {
            String q1 = "select z.ubytovani_ubytovani_id, pokoj_id from skiresort.zakaznik z "
                    + "join skiresort.ubytovani u on(u.ubytovani_id=z.ubytovani_ubytovani_id)"
                    + "join skiresort.pokoj p on(u.ubytovani_id=p.ubytovani_ubytovani_id)"
                    + "join skiresort.strava s on (s.UBYTOVANI_UBYTOVANI_ID=u.UBYTOVANI_ID)"
                    + "where zakaznik_id=?";

            PreparedStatement stm = conn.prepareStatement(q1);
            stm.setInt(1, zakId);
            stm.execute();

            ResultSet rs = stm.getResultSet();

            rs.next();

            //ubytId = rs.getInt("ubytovani_ubytovani_id");
            pokojId = rs.getInt("pokoj_id");
            System.out.println(pokojId);
            stm.close();

            String q2 = "UPDATE skiresort.pokoj SET ubytovani_ubytovani_id=null, volny=true WHERE pokoj_id=?";
            stm = conn.prepareStatement(q2);
            stm.setInt(1, pokojId);
            stm.executeUpdate();
            System.out.println("pokoj updatnut");





        } catch (SQLException ex) {
            Logger.getLogger(ZakaznikDbService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void pridatPerm(String[] permInfo) {
        try {
            // permInfo[zakID, cena, typPerm]
            Permanentka p;
            String queryPerm = "insert into skiresort.permanentka (CENA ,TYP_PERMANENTKY ,ZAKAZNIK_ZAKAZNIK_ID ) values (?, ?, ?);";

            PreparedStatement stm = conn.prepareStatement(queryPerm);
            stm.setString(1, permInfo[1].toString()); // cena
            stm.setString(2, permInfo[2].toString()); // typ
            stm.setString(3, permInfo[0].toString());
            stm.execute();




        } catch (SQLException ex) {
            Logger.getLogger(ZakaznikDbService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<AidPermInfo> getPerm() {
        permInfa = new ArrayList<>();
        try {
            if (conn != null) {
                // TODO: poresit lepsi query :s
                String queryPermanentka = "SELECT z.JMENO ,z.PRIJMENI, z.ZAKAZNIK_ID , p.TYP_PERMANENTKY , p.CENA , p.ZAKAZNIK_ZAKAZNIK_ID FROM SKIRESORT.ZAKAZNIK z, SKIRESORT.PERMANENTKA p WHERE z.ZAKAZNIK_ID = p.ZAKAZNIK_ZAKAZNIK_ID;";
                try (Statement stm = conn.createStatement();) {
                    ResultSet rs = stm.executeQuery(queryPermanentka);

                    while (rs.next()) {
                        Zakaznik z = new Zakaznik();
                        z.setJmeno(rs.getString("jmeno"));
                        z.setPrijmeni(rs.getString("prijmeni"));
                        Permanentka p = new Permanentka();
                        p.setTyp_permanentka(rs.getString("typ_permanentky"));
                        p.setCena(rs.getDouble("cena"));
                        permInfa.add(new AidPermInfo(p, z));
                    }
                } catch (Exception ex) {
                    System.out.println("chyba v getPerm()");
                }
            }
        } catch (Exception ex) {
            System.out.println("selhal select permanentky");
        }
        return permInfa;
    }

    @Override
    public void vytvVyp(Date dateOd, Date dateDo, Double celkovaCena, String ZakId, List<Produkt> produktyPridane) {
        try {
            String qVyp = "insert into skiresort.vypujcka (datum_vypujcky, datum_vraceni, cena_k_zaplaceni, zakaznik_zakaznik_id, vraceno_vcas) values( ?, ?, ?, ?, null )";

            PreparedStatement stm = conn.prepareStatement(qVyp, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String dateOdStr = sdf.format(dateOd);
            String dateDoStr = sdf.format(dateDo);

            stm.setString(1, dateOdStr);
            stm.setString(2, dateDoStr);
            stm.setDouble(3, celkovaCena);
            stm.setInt(4, Integer.valueOf(ZakId));

            stm.execute();
            System.out.println("vyp vytvorena");
            ResultSet generatedKeys = stm.getGeneratedKeys();

            generatedKeys.next();
            int vypId = generatedKeys.getInt(1);

            upravProd(vypId, produktyPridane);





        } catch (SQLException ex) {
            Logger.getLogger(ZakaznikDbService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void upravProd(int vypId, List<Produkt> produktyPridane) {
        try {
            String qProd = "update skiresort.produkt SET pujceno=true, vypujcka_vypujcka_id=? where produkt_id=?";

            PreparedStatement stm = conn.prepareStatement(qProd);

            for (Produkt p : produktyPridane) {
                stm.setInt(1, vypId);
                stm.setInt(2, p.getProdukt_id());
                stm.executeUpdate();
                System.out.println("prod updatnut");




            }

        } catch (SQLException ex) {
            Logger.getLogger(ZakaznikDbService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public List<AidVypInfo> getVypInfa() {
        vypInfa = new ArrayList<>();
        try {
            if (conn != null) {
                String qZakVyp = "SELECT z.zakaznik_id, z.jmeno, z.prijmeni,"
                        + "v.vypujcka_id, v.DATUM_VYPUJCKY, v.DATUM_VRACENI, v.vraceno_vcas, v.zakaznik_zakaznik_id, v.cena_k_zaplaceni FROM "
                        + "skiresort.zakaznik z JOIN skiresort.vypujcka v ON v.ZAKAZNIK_ZAKAZNIK_ID = z.ZAKAZNIK_ID";

                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(qZakVyp);

                while (rs.next()) {
                    Zakaznik z = new Zakaznik();
                    z.setZakaznik_id(rs.getInt("zakaznik_id"));
                    z.setJmeno(rs.getString("jmeno"));
                    z.setPrijmeni(rs.getString("prijmeni"));

                    Vypujcka v = new Vypujcka();
                    v.setVypujcka_id(rs.getInt("vypujcka_id"));
                    v.setDatum_vypujcky(rs.getDate("datum_vypujcky"));
                    v.setDatum_vraceni(rs.getDate("datum_vraceni"));
                    v.setCena_k_zaplaceni(rs.getDouble("cena_k_zaplaceni"));
                    v.setZakaznik(z);
                    v.setVraceno_vcas(rs.getBoolean("vraceno_vcas"));

                    vypInfa.add(new AidVypInfo(z, v));
                }

                return vypInfa;




            }
        } catch (SQLException ex) {
            Logger.getLogger(ZakaznikDbService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;


    }

    @Override
    public void odstrVyp(int vypId) {

        productIds = new ArrayList<>();

        System.out.println("uz to vola odstrVyp v dbservice");

        try {

            String q1 = "SELECT p.PRODUKT_ID , p.VYPUJCKA_VYPUJCKA_ID, p.PUJCENO, v.vypUJCKA_ID FROM "
                    + "SKIRESORT.PRODUKT p JOIN SKIRESORT.VYPUJCKA v ON (p.VYPUJCKA_VYPUJCKA_ID = v.vypUJCKA_ID) WHERE v.VYPUJCKA_ID = ?";

            PreparedStatement stm = conn.prepareStatement(q1);

            stm.setInt(1, vypId);

            stm.execute();

            ResultSet rs = stm.getResultSet();

            int i = 0;
            while (rs.next()) {
                productIds.add(rs.getInt("produkt_id"));
                System.out.println(productIds.get(i));
                i++;
            }

            stm.close();

            String q2 = "UPDATE skiresort.VYPUJCKA SET vraceno_vcas=?, zakaznik_zakaznik_id=null WHERE vypujcka_id=?";
            stm = conn.prepareStatement(q2);
            stm.setBoolean(1, vracenoVcas);
            stm.setInt(2, vypId);

            stm.execute();

            System.out.println("výpůjčka updatnuta");

            for (Integer idProd : productIds) {
                String q3 = "UPDATE skiresort.PRODUKT SET pujceno=false, vypujcka_vypujcka_id=null WHERE produkt_id=?";
                stm = conn.prepareStatement(q3);
                stm.setInt(1, idProd);
                stm.execute();
                System.out.println("produkt updatnut");




            }

        } catch (SQLException ex) {
            Logger.getLogger(ZakaznikDbService.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println(
                    "chyba při odstranění výpůjčky");
        }

    }

    @Override
    public void setVracenoVcas(boolean vracenoVcas) {
        this.vracenoVcas = vracenoVcas;
    }
}