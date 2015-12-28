
package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;
import java.util.Collections;

public class Pakka {

    private ArrayList<Kortti> pakka;
        
    public Pakka(){
        pakka = new ArrayList();
        luoKortit();
        sekoita();
    }
    
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
    
    public void sekoita(){
        Collections.shuffle(pakka);
    }
    
    public Kortti otaEka(){
        Kortti apu = pakka.get(0);
        pakka.remove(pakka.get(0));
        return apu;
    }
    
    public int montaPakassa(){
        return pakka.size();
    }
    
    public Poyta jaaKortit(Poyta poyta){
        for (Pelaaja pelaaja : poyta.getPelaajat()) {
            for (int i = 0; i < 7; i++) {
                Kortti apu = otaEka();
                pelaaja.nostaKortti(apu);
            }
        }
        return poyta;
    }
    
    public void sekoitaPakkaan(ArrayList<Kortti> poydallaOlevatKortit){
        for (Kortti kortti : poydallaOlevatKortit) {
            pakka.add(kortti);
        }
        sekoita();
    }
}
