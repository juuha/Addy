
package addykorttipeligroupid.addykorttipeli.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tämä luokka luo skannerin, jonka avulla pystytään lukemaan ohje tiedosto.
 * @author ritakosk
 */
public class Lukija {
    
    private Scanner lukija;
    private final File ohje;
    
    /**
     *
     */
    public Lukija() {
        ohje = new File("/home/ritakosk/Addy/AddyKorttiPeli/Ohjeet");
        alustus();
    }
    
    private void alustus(){
        try {
            lukija = new Scanner(ohje);
        } catch (FileNotFoundException ex) {
            System.out.println("tiedostoa ei löydy");
        }
    }
    
    /**
     * tämä metodi lukee aiemmin annetun tiedoston ja luo siitä ArrayListan.
     * @return palauttaa ohje tiedoston ArrayListinä, joka sisältää String tyyppisiä muuttujia.
     */
    public ArrayList<String> haeOhjeet(){
        ArrayList<String> ohjeet = new ArrayList();
        while(lukija.hasNextLine()){
            ohjeet.add(lukija.nextLine());
        }
        return ohjeet;
    }
    
    
    
}
