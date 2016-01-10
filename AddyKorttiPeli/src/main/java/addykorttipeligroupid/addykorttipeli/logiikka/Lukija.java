
package addykorttipeligroupid.addykorttipeli.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Lukija {
    
    private Scanner lukija;
    private final File file;
    
    public Lukija() {
        file = new File("/home/ritakosk/Addy/AddyKorttiPeli/Ohjeet");
        apu();
    }
    
    public ArrayList<String> haeOhjeet(){
        ArrayList<String> ohjeet = new ArrayList();
        while(lukija.hasNextLine()){
            ohjeet.add(lukija.nextLine());
        }
        return ohjeet;
    }
    
    private void apu(){
        try {
            lukija = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("tiedostoa ei löydy");
        }
    }
    
}
