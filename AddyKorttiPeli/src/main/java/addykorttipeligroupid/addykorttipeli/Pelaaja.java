package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;

public class Pelaaja {

    private String nimi;
    private ArrayList<Kortti> kasi;
    private int tallaVuorollaNostettu;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.kasi = new ArrayList();
        this.tallaVuorollaNostettu = 0;
    }
    
    public String getNimi(){
        return nimi;
    }

    public Kortti getKorttiArvolta(String maa, int arvo) {
        Kortti apu = null;
        for (Kortti kortti : kasi) {
            if (kortti.getArvo() == arvo && kortti.getMaa().equals(maa)) {
                apu = kortti;
            }
        }
        return apu;
    }

    
    public String kadessaOlevatKortit() {
        String kadessa = "Kädessä on ";
        for (Kortti kortti : kasi) {
            kadessa += kortti.getMaa() + " " + kortti.getArvo() + ", ";
        }
        kadessa = kadessa.substring(0, kadessa.length()-2);
        kadessa += ".";
        return kadessa;
    }
    
    public void otaKorttiKadesta(String maa, int arvo){
        Kortti apu = null;
        for (Kortti kortti : kasi) {
            if (kortti.getArvo() == arvo && kortti.getMaa().equals(maa)) {
                break;
            }
        }
        if (apu == null){
            kasi.remove(apu);
        }
    }
    
    public void nostaKortti(Kortti kortti){
        kasi.add(kortti);
        tallaVuorollaNostettu++;
    }
    
    public int getTallaVuorollaNostettu(){
        return tallaVuorollaNostettu;
    }
    
    public int montaKorttiaKadessa(){
        return kasi.size();
    }
    
    public void nollaaKorttienNostot(){
        tallaVuorollaNostettu = 0;
    }

}
