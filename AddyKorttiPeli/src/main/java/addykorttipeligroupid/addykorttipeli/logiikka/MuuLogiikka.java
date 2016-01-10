package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Pakka;
import addykorttipeligroupid.addykorttipeli.Pelaaja;
import addykorttipeligroupid.addykorttipeli.Poyta;
import addykorttipeligroupid.addykorttipeli.graafinenkayttoliittyma.NimenValinta;
import addykorttipeligroupid.addykorttipeli.graafinenkayttoliittyma.VoittoRuutu;

/**
 *
 * Luokka sisältää logiikkaa koko ohjelmalle.
 */
public class MuuLogiikka {

    private static Poyta poyta = new Poyta(new Pakka());
    private static int odota = 0;
    private static Vuoro vuoro;
    
    /**
     *  alustaa vuoro olion ja tarkistaa onko eka vuoro. kutsuu vuoro luokan vuoro metodia.
     */
    public static void pelaa() {
        vuoro = new Vuoro(poyta);
        if (vuoro.getPoyta().onkoEkaVuoro()){
            vuoro.aloitaPeli();
            vuoro.getPoyta().ekaVuoroOhi();
        }
        vuoro.vuoro();
    }


    /**
     * luo parametrin verran nimenvalinta ruutuja
     * @param luku
     */
    public static void luoPelaajat(int luku) {
        odota = luku;
        for (int i = 0; i < luku; i++) {
            NimenValinta nm = new NimenValinta();
        }
    }

    /**
     *  luo voittoruutu olion
     */
    public static void voitto(){
        VoittoRuutu vr = new VoittoRuutu();
    }

    /**
     *  sulkee ohjelman
     */
    public static void lopeta() {
        System.exit(0);
    }
    
    /**
     * Luo pelaajat kyseisellä parametrin nimellä.
     * @param nimi
     */
    public static void luoPelaajaNimelta(String nimi){
        poyta.lisaaPelaaja(new Pelaaja(nimi));
    }
    
    
    public static Poyta getPoyta(){
        return poyta;
    }
    
    
    public static int getOdota(){
        return odota;
    }
    
    
    public static void odota(){
        odota--;
    }
    
    
    public static Vuoro getVuoro(){
        return vuoro;
    }
    
    /**
     *  luo uuden pöydän vanhan tilalle.
     */
    public static void nollaaPeli(){
        poyta = new Poyta(new Pakka());
    }
}
