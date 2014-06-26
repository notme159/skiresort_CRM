package model.sluzby;

import java.util.Date;
import java.util.List;
import model.component.AidPermInfo;
import model.component.AidProdInfo;
import model.component.AidVypInfo;
import model.component.AidZakInfo;
import model.entity.Pokoj;
import model.entity.Produkt;

public interface IntZakaznikService {

    /**
     * Vypíše tabulku zákazníků v databázi, aktuálně ubytovaných
     *
     * @return
     */
    public List<AidZakInfo> prehledZak();

    /**
     * Přidá zákazníka do dtb
     *
     * @param zakInfo
     */
    
    public void pridatZak(String[] zakInfo);

    /**
     * Odhlásí zákazníka z dtb, uvolní pokoj
     *
     * @param zakId - informace pro odstraneni zákazníka
     */
    
    public void odstrZak(int zakId);

    /**
     * vrací info o produktech a jejich kategorii
     *
     * @return
     */
    public List<AidProdInfo> getProdukty();

    /**
     * vrací list pokojů
     *
     * @return
     */
    public List<Pokoj> getPokoje();

    /**
     * Přidá vybranému zákazníkovi permanentku
     *
     * @param zakInfo
     */
    public void pridatPerm(String[] permInfo);
    
    /**
     * vrací list s infem o permanentkách
     * @return 
     */
    public List<AidPermInfo> getPerm();

    /**
     * vytvoří novou výpůjčku a nastaví u produktů půjčeno: true
     * 
     * @param dateOd
     * @param dateDo
     * @param celkovaCena
     * @param zakId
     * @param produktyPridane 
     */
    public void vytvVyp(Date dateOd, Date dateDo, Double celkovaCena, String zakId, List<Produkt> produktyPridane);

    /**
     * vrací info o zákaznících a jejich výpůjčkách
     * @return 
     */
    public List<AidVypInfo> getVypInfa();
    
    /**
     * odstraní výpůjčku podle id
     * @param vypId 
     */
    public void odstrVyp(int vypId);
    
    /**
     * pomocný setter pro metodu odstrVyp()
     * @param vracenoVcas 
     */
    public void setVracenoVcas(boolean vracenoVcas);

}