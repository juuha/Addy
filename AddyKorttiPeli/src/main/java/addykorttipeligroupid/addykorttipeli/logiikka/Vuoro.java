package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Kortti;
import addykorttipeligroupid.addykorttipeli.Poyta;
import addykorttipeligroupid.addykorttipeli.graafinenkayttoliittyma.AloitaVuoroRuutu;
import java.util.ArrayList;

/**
 *
 * Tämä luokka sisältää kaiken mitä tapahtuu pelivuorojenaikana.
 */
public class Vuoro {

    private final Poyta poyta;
    private int voitto = 0;
    private ArrayList<Kortti> paallimaisenaPelattavat;
    private Kortti paallimmaisenaPelattava;

    

    

    /**
     * tämä metodi toimii luokan konstruktorina.
     * @param poyta
     */
    public Vuoro(Poyta poyta) {
        this.poyta = poyta;

    }

    /**
     * Jakaa kortit ja antaa ensimmäisen vuoron ensimmäiselle pelaajalle.
     */
    public void aloitaPeli() {
        poyta.setVuoroAlussa();
        poyta.getPakka().jaaKortit(poyta);
    }


    
    /**
     * tämä metodi kutsuu valmistelut metodia ja luo AloitaVuoroRuudu olion.
     */
    public void vuoro() {
        valmistelut();
        AloitaVuoroRuutu avr = new AloitaVuoroRuutu();
    }

    /**
     *  tämä metodi suorittaa vuoron lopussa tarvittavat asiat.
     */
    public void jalkivalmistelut() {
        if (poyta.getTamanVuoronPelaaja().montaKorttiaKadessa() == 0) {
            voitto = 1;
            return;
        }

        if (poyta.onkoEkaVuoro() == false) {
            poyta.ekaVuoroOhi();
        }

        poyta.setTamanVuoronPelaaja();
    }

    /**
     * tämä metodi suorittaa vuoron alussa tarvittavat asiat ja tarkistaa onko
     * pelin ensimmäinen vuoro ja suorittaa valmisteluja jos on.
     */
    public void valmistelut() {
        voitto = 0;
        poyta.getTamanVuoronPelaaja().nollaaKorttienNostot();
        if (poyta.onkoEkaVuoro()) {
            poyta.setPaallimmainen(poyta.getPakka().otaEka());
            poyta.laitaPoydallaOleviinKortteihin(poyta.getPaallimmainen());
        }
    }

    /**
     * tämä metodi pelaa sille annetut kortit pöytään ja poistaa kyseiset kortit
     * pelaajan kädestä.
     * @param ArrayList<Kortti> kortit
     */
    public void pelaa(ArrayList<Kortti> kortit) {
        poyta.setPaallimmainen(paallimmaisenaPelattava); 
        for (Kortti kortti : kortit) {
            poyta.getTamanVuoronPelaaja().otaKorttiKadesta(kortti.getMaa(), kortti.getArvo());
            poyta.laitaPoydallaOleviinKortteihin(kortti);
        }
    }

    /**
     * tämä metodi tarkistaa onko pelaaja jo nostanut 3 korttia ja jos ei ole,
     * ottaa pakasta yhden kortin ja laittaa sen tämän vuoron pelaajan käteen.
     * @return
     */
    public boolean nostaKortti() {
        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() >= 3) {
            return true;
        } else {
            if (poyta.getPakka().montaPakassa() < 1) {
                if (poyta.getPoydallaOlevatKortit().size() > 0) {
                    poyta.getPakka().sekoitaPakkaan(poyta.getPoydallaOlevatKortit());
                    poyta.tyhjennaPoyta();
                }
            }
            Kortti apuKortti = poyta.getPakka().otaEka();
            poyta.getTamanVuoronPelaaja().nostaKortti(apuKortti);
        }
        return false;
    }

    /**
     * tämä metodi tarkistaa onko sille annettujen korttien arvojen summa yhtäsuuri
     * kuin pöydällä olevan kortin arvo.
     * @param pelattavatKortit
     * @return palauttaa true, jos kortit voi pelata ja false jos ei voi.
     */
    public boolean voikoKortitPelata(ArrayList<Kortti> pelattavatKortit) {
        int summa = 0;
        for (Kortti kortti : pelattavatKortit) {
            summa += kortti.getArvo();
        }
        while (summa > 9) {
            summa -= 10;
        }
        return poyta.getPaallimmainen().getNumeroArvo() == summa;
    }

    
    public Poyta getPoyta() {
        return poyta;
    }

    
    public int getVoitto() {
        return voitto;
    }
    
    
    public ArrayList<Kortti> getPaallimaisenaPelattavat() {
        return paallimaisenaPelattavat;
    }

    
    public void setPaallimaisenaPelattavat(ArrayList<Kortti> paallimaisenaPelattavat) {
        this.paallimaisenaPelattavat = paallimaisenaPelattavat;
    }
    
    
    public Kortti getPaallimmaisenaPelattava() {
        return paallimmaisenaPelattava;
    }

    
    public void setPaallimmaisenaPelattava(Kortti paallimmaisenaPelattava) {
        this.paallimmaisenaPelattava = paallimmaisenaPelattava;
    }

}
