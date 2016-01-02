
package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;

/**
 *
 * Tämä luokka sisältää pelipöytään liittyvät asiat, jossa pakka ja pelatut kortit sijaitsevat.
 */
public class Poyta {
    
    private Kortti paallimmainen;
    private ArrayList<Kortti> poydallaOlevatKortit;
    private ArrayList<Pelaaja> pelaajat;
    private Pelaaja tamanVuoronPelaaja;
    private Pelaaja seuraavanVuoronPelaaja;
    private boolean pelinEkaVuoro;
    private String viimeVuorollaPelattu = "";
    private Pakka pakka;
    
    /**
     *
     * @param pakka
     */
    public Poyta(Pakka pakka){
        paallimmainen = pakka.otaEka();
        pelaajat = new ArrayList();
        poydallaOlevatKortit = new ArrayList();
        pelinEkaVuoro = true;
        this.pakka = pakka;
    }
    
    /**
     *
     * @return  palauttaa viimeiseksi pelatun kortin. 
     */
    public Kortti getPaallimmainen(){
        return paallimmainen;
    }
    
    /**
     * Lisää pelaajan pöytään.
     * 
     * @param pelaaja
     */
    public void lisaaPelaaja(Pelaaja pelaaja){
        pelaajat.add(pelaaja);
    }
    
    /**
     * Asettaa tämän ja seuraavan vuoron pelaajat pelin alussa.
     */
    public void setVuoroAlussa(){
        tamanVuoronPelaaja = pelaajat.get(0);
        setSeuraavanVuoronpelaaja();
    }
    
    /**
     *  Asettaa tämän vuoron pelaajaksi seuraavan vuoron pelaajan ja asettaa
     *  seuraavan vuoron pelaajan sitä seuraavaksi.
     */
    public void setTamanVuoronPelaaja(){
        tamanVuoronPelaaja = seuraavanVuoronPelaaja;
        setSeuraavanVuoronpelaaja();
    }
    
    
    public Pelaaja getTamanVuoronPelaaja(){
        return tamanVuoronPelaaja;
    }
    
    
    public void setSeuraavanVuoronpelaaja(){
        for (int i = 0; i < pelaajat.size(); i++) {
            if( pelaajat.get(i).equals(tamanVuoronPelaaja)){
                if ((i+1) < pelaajat.size()){
                    seuraavanVuoronPelaaja = pelaajat.get(i+1);
                } else {
                    seuraavanVuoronPelaaja = pelaajat.get(0);
                }
            }
        }
    }
    
    
    public Pelaaja getSeuraavanVuoronPelaaja(){
        return seuraavanVuoronPelaaja;
    }
    
    /**
     *  Asettaa pelin ensimmäisen vuoron pelatuksi.
     */
    public void ekaVuoroOhi(){
        pelinEkaVuoro = false;
    }
    
    /**
     *
     * @return    palauttaa vastauksen kysymykseen: onko eka vuoro?
     */
    public boolean onkoEkaVuoro(){
        return pelinEkaVuoro;
    }
    
    
    public void setViimeVuorollaPelattu(String pelatut){
        viimeVuorollaPelattu = pelatut;
    }
    
    
    public String getViimeVuorollaPelattu(){
        return viimeVuorollaPelattu;
    }
    
    
    public Pakka getPakka(){
        return pakka;
    }
    
    
    public ArrayList<Pelaaja> getPelaajat(){
        return pelaajat;
    }
    
    
    public void setPaallimmainen(Kortti kortti){
        paallimmainen = kortti;
    }
    
    /**
     * Laittaa kortin jo pelattuihin kortteihin
     * 
     * @param kortti
     */
    public void laitaPoydallaOleviinKortteihin(Kortti kortti){
        poydallaOlevatKortit.add(kortti);
    }
    
    
    public ArrayList<Kortti> getPoydallaOlevatKortit(){
        return poydallaOlevatKortit;
    }
}
