
package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;


public class Poyta {
    
    private Kortti paallimmainen;
    private ArrayList<Kortti> poydallaOlevatKortit;
    private ArrayList<Pelaaja> pelaajat;
    private Pelaaja tamanVuoronPelaaja;
    private Pelaaja seuraavanVuoronPelaaja;
    private boolean pelinEkaVuoro;
    private String viimeVuorollaPelattu = "";
    private Pakka pakka;
    
    public Poyta(Pakka pakka){
        paallimmainen = pakka.otaEka();
        pelaajat = new ArrayList();
        poydallaOlevatKortit = new ArrayList();
        pelinEkaVuoro = true;
        this.pakka = pakka;
    }
    
    public Kortti getPaallimmainen(){
        return paallimmainen;
    }
    
    public void lisaaPelaaja(Pelaaja pelaaja){
        pelaajat.add(pelaaja);
    }
    
    public void setVuoroAlussa(){
        tamanVuoronPelaaja = pelaajat.get(0);
        setSeuraavanVuoronpelaaja();
    }
    
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
    
    public void ekaVuoroOhi(){
        pelinEkaVuoro = false;
    }
    
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
    
    public void laitaPoydallaOleviinKortteihin(Kortti kortti){
        poydallaOlevatKortit.add(kortti);
    }
    
    public ArrayList<Kortti> getPoydallaOlevatKortit(){
        return poydallaOlevatKortit;
    }
}
