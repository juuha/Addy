package addykorttipeligroupid.addykorttipeli;

/**
 *
 * Tämä luokka sisältää kaiken pelikortteihin liittyvän.
 */
public class Kortti {

    private String maa;
    private int arvo;

    /**
     *
     * @param maa
     * @param arvo
     */
    public Kortti(String maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    
    public int getArvo() {
        return arvo;
    }
    
    /**
     *
     * palauttaa kortin todellisen pelissä käytettävän arvon
     */
    public int getNumeroArvo(){
        int apu = arvo % 10;
        return apu;
    }

    
    public String getMaa() {
        return maa;
    }

    @Override
    public String toString() {
        return maa + " "+ arvo;
    }

}
