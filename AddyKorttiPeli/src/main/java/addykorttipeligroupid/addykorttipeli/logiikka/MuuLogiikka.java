package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Pakka;
import addykorttipeligroupid.addykorttipeli.Pelaaja;
import addykorttipeligroupid.addykorttipeli.Poyta;
import graafinenkayttoliittyma.NimenValinta;
import java.util.Scanner;

/**
 *
 * Luokka sisältää logiikkaa koko ohjelmalle, ja toimii tekstipohjaisen version
 * käynnistyspohjana.
 */
public class MuuLogiikka {

    private static Poyta poyta = new Poyta(new Pakka());
    private static Scanner lukija = new Scanner(System.in);
    private static int odota = 0;

    /**
     *
     * Pistää tekstipohjaisen ohjelman käyntiin, pitää vain muuttaa nbactions.xml main
     * luokka täksi luokaksi. 
     */
    public void main(String[] args) {

        lukija = new Scanner(System.in);
        while (true) {
            System.out.println("Mitä tehdään? (pelaa/ohjeet/lopeta)");
            String kasky = lukija.nextLine();
            if (kasky.equals("lopeta")) {
                System.out.println("Näkemiin.");
                break;
            } else if (kasky.equals("ohjeet")) {
                tulostaOhjeet();
            } else if (kasky.equals("pelaa")) {
                poyta = new Poyta(new Pakka());
                pelaa();
            } else {
                System.out.println("Virheellinen syöte. Anna jokin seuraavista:"
                        + " pelaa/ohjeet/lopeta");
            }
        }
    }

    /**
     * tulostaa pelin ohjeet, ei valmis
     */
    public static void tulostaOhjeet() {
        System.out.println("Ohjeet: (ei valmis, valmiissa avaa tiedoston, jossa ohjeet)");
    }

    /**
     *  Vanha pelaa() metodi, joka luo vuoron, pelaajat ja aloittaa pelin ja tarkistaa
     *  joka vuoron jälkeen voittiko kukaan. Lopussa metodi suorittaa voitto() metodin.
     */
    public static void pelaa() {
        Vuoro vuoro = new Vuoro(lukija, poyta);
        montaPelaajaa();
        vuoro.aloitaPeli();

        while (true) {
            int lopeta = vuoro.vuoro();
            if (lopeta == 1) {
                break;
            }
        }
        voitto();
    }
    
    public static void pelaaGUI() {
        Vuoro vuoro = new Vuoro(lukija, poyta);
        vuoro.aloitaPeli();
        vuoro.vuoroGUI();
    }

    
    private static void montaPelaajaa() {
        while (true) {
            System.out.println("Monta pelaajaa? (2-4)");
            String apu = lukija.nextLine();
            try {
                int luku = Integer.parseInt(apu);
                if (luku != 2 && luku != 3 && luku != 4) {
                    System.out.println("Virheellinen syöte. Anna luku 2/3/4");
                } else {
                    luoPelaajat(luku);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Virheellinen syöte.");
            }
        }
    }
    
    /**
     *
     * @param luku
     */
    

    private static void luoPelaajat(int luku) {
        for (int i = 1; i <= luku; i++) {
            poyta.lisaaPelaaja(new Pelaaja("" + i));
        }
        
    }
    
    /**
     *
     * @param luku
     */
    public static void luoPelaajatGUI(int luku) {
        odota = luku;
        for (int i = 0; i < luku; i++) {
            NimenValinta.main(null);
        }
    }

    private static void voitto() {
        Pelaaja apu = poyta.getTamanVuoronPelaaja();
        System.out.println("Pelaaja " + apu.getNimi() + " voitti pelin!");
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
    
    public static Scanner getLukija(){
        return lukija;
    }
    
    public static int getOdota(){
        return odota;
    }
    
    public static void odota(){
        odota--;
    }
}
