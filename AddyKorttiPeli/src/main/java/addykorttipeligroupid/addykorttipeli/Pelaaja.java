package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;

/**
 *
 * Tämä luokka sisältää tiedot pelaajista.
 */
public class Pelaaja {

    private final String nimi;
    private final ArrayList<Kortti> kasi;
    private int tallaVuorollaNostettu;

    /**
     *
     * @param nimi
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.kasi = new ArrayList();
        this.tallaVuorollaNostettu = 0;
    }
    
    
    public String getNimi(){
        return nimi;
    }

    /**
     * Tarkistaa onko kortti pelaajan kädessä
     * 
     * @param maa
     * @param arvo
     * @return   palauttaa kortin jos se on pelaajan kädessä
     */
    public Kortti getKorttiArvolta(String maa, int arvo) {
        Kortti apu = null;
        for (Kortti kortti : kasi) {
            if (kortti.getArvo() == arvo && kortti.getMaa().equals(maa)) {
                apu = kortti;
            }
        }
        return apu;
    }

    /**
     *
     * @return  palauttaa tekstin, joka kertoo mitä kortteja pelaajan kädessä on.
     */
    public String kadessaOlevatKortit() {
        String kadessa = "Kädessä on ";
        for (Kortti kortti : kasi) {
            kadessa += kortti.getMaa() + " " + kortti.getArvo() + ", ";
        }
        kadessa = kadessa.substring(0, kadessa.length()-2);
        kadessa += ".";
        return kadessa;
    }
    
    /**
     * Poistaa kortin pelaajan kädestä, jos hänellä on kyseinen kortti.
     * 
     * @param maa
     * @param arvo
     */
    public void otaKorttiKadesta(String maa, int arvo){
        Kortti apu = this.getKorttiArvolta(maa, arvo);
        if (apu != null){
            kasi.remove(apu);
        }
    }
    
    /**
     * Pelaaja nostaa pakasta yhden kortin omaan käteensä.
     * 
     * @param kortti
     */
    public void nostaKortti(Kortti kortti){
        kasi.add(kortti);
        tallaVuorollaNostettu++;
    }
    
    /**
     *
     * @return
     */
    public int getTallaVuorollaNostettu(){
        return tallaVuorollaNostettu;
    }
    
    /**
     *
     * @return  palauttaa monta korttia pelaajalla on kädessään.
     */
    public int montaKorttiaKadessa(){
        return kasi.size();
    }
    
    /**
     * Nollaa pelaajan korttien nostot, tapahtuu joka vuoron alussa.
     */
    public void nollaaKorttienNostot(){
        tallaVuorollaNostettu = 0;
    }
    
    public ArrayList<Kortti> getKadessaOlevatKortit(){
        return kasi;
    }

}
