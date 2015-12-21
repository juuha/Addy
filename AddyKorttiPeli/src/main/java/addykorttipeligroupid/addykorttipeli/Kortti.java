package addykorttipeligroupid.addykorttipeli;

public class Kortti {

    private String maa;
    private int arvo;

    public Kortti(String maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public int getArvo() {
        return arvo;
    }

    public String getMaa() {
        return maa;
    }

    @Override
    public String toString() {
        return maa + " "+ arvo;
    }

}
