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
     * tulostaa pelin ohjeet, ei valmis
     */
    public static void tulostaOhjeet() {
        System.out.println("Ohjeet: (ei valmis, valmiissa avaa tiedoston, jossa ohjeet)");
    }



    
    public static void pelaa() {
        vuoro = new Vuoro(poyta);
        if (vuoro.getPoyta().onkoEkaVuoro()){
            vuoro.aloitaPeli();
            vuoro.getPoyta().ekaVuoroOhi();
        }
        vuoro.vuoro();
    }


    /**
     *
     * @param luku
     */
    public static void luoPelaajat(int luku) {
        odota = luku;
        for (int i = 0; i < luku; i++) {
            NimenValinta nm = new NimenValinta();
        }
    }

    
    public static void voitto(){
        VoittoRuutu vr = new VoittoRuutu();
    }

    /**
     *
     */
    public static void lopeta() {
        System.exit(0);
    }
    
    /**
     *
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
    
    public static void nollaaPeli(){
        poyta = new Poyta(new Pakka());
    }
}
