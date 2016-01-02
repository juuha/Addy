
package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *  Tämä luokka sisältää kaiken korttipakkaan liittyvät asiat.
 */
public class Pakka {

    private ArrayList<Kortti> pakka;
        
    /**
     *  luo pakan sekoituksella
     */
    public Pakka(){
        pakka = new ArrayList();
        luoKortit();
        sekoita();
    }
    
    /**
     * luo pakan ilman sekoitusta (testejä varten)
     * @param ilmansekotusta
     */
    public Pakka(String ilmansekotusta){
        pakka = new ArrayList();
        luoKortit();  
    }

    private void luoKortit() {
        luoKorttienArvot("hertta");
        luoKorttienArvot("pata");
        luoKorttienArvot("ruutu");
        luoKorttienArvot("risti");
    }

    private void luoKorttienArvot(String maa) {
        for (int i = 1; i <= 13; i++) {
            pakka.add(new Kortti(maa, i));
        }
    }
    
    /**
     *
     */
    public void sekoita(){
        Collections.shuffle(pakka);
    }
    
    /**
     * Ottaa kortin pakasta, eli poistaa sen pakasta ja palauttaa sen kutsujalle
     * 
     * @return    palauttaa pakasta otetun kortin
     */
    public Kortti otaEka(){
        Kortti apu = pakka.get(0);
        pakka.remove(pakka.get(0));
        return apu;
    }
    
    /**
     *
     * @return    palauttaa pakan sisältämän korttimäärän
     */
    public int montaPakassa(){
        return pakka.size();
    }
    
    /**
     * Jakaa 7 korttia joka pelaajalle
     * 
     * @param poyta
     */
    public void jaaKortit(Poyta poyta){
        for (Pelaaja pelaaja : poyta.getPelaajat()) {
            for (int i = 0; i < 7; i++) {
                Kortti apu = otaEka();
                pelaaja.nostaKortti(apu);
            }
        }
        
    }
    
    /**
     * Sekoittaa jo pelatut kortit takaisin pakkaan. Käytetään silloin, kun pakka
     * on lähes tyhjä.
     * 
     * @param poydallaOlevatKortit
     */
    public void sekoitaPakkaan(ArrayList<Kortti> poydallaOlevatKortit){
        for (Kortti kortti : poydallaOlevatKortit) {
            pakka.add(kortti);
        }
        sekoita();
    }
}
