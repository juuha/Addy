package addykorttipeligroupid.addykorttipeli;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        while (true) {
            System.out.println("Mitä tehdään? (pelaa/ohjeet/lopeta)");
            String kasky = lukija.nextLine();
            if (kasky.equals("lopeta")) {
                System.out.println("Näkemiin.");
                break;
            } else if (kasky.equals("ohjeet")) {
                tulostaOhjeet();
            } else if (kasky.equals("pelaa")) {
                Poyta poyta = new Poyta(new Pakka());
                pelaa(lukija, poyta);
            } else {
                System.out.println("Virheellinen syöte. Anna jokin seuraavista:"
                        + " pelaa/ohjeet/lopeta");
            }
        }
    }

    private static void tulostaOhjeet() {
        System.out.println("Ohjeet:");
    }

    private static void pelaa(Scanner lukija, Poyta poyta) {
        Vuoro vuoro = new Vuoro(lukija, poyta);
        montaPelaajaa(lukija, poyta);
        vuoro.aloitaPeli();
        
        while (true){
            int lopeta = vuoro.vuoro();
            if (lopeta == 1){
                break;
            }
        }
        
        
        voitto(poyta);
        
    }

    public static Poyta montaPelaajaa(Scanner lukija, Poyta poyta) {
        while (true) {
            System.out.println("Monta pelaajaa? (2-4)");
            String apu = lukija.nextLine();
            try {
                int luku = Integer.parseInt(apu);
                if (luku != 2 && luku != 3 && luku != 3) {
                    System.out.println("Virheellinen syöte. Anna luku 2/3/4");
                } else if (luku == 2) {
                    poyta.lisaaPelaaja(new Pelaaja("eka"));
                    poyta.lisaaPelaaja(new Pelaaja("toka"));
                    break;
                } else if (luku == 3) {
                    poyta.lisaaPelaaja(new Pelaaja("eka"));
                    poyta.lisaaPelaaja(new Pelaaja("toka"));
                    poyta.lisaaPelaaja(new Pelaaja("kolmas"));
                    break;
                } else {
                    poyta.lisaaPelaaja(new Pelaaja("eka"));
                    poyta.lisaaPelaaja(new Pelaaja("toka"));
                    poyta.lisaaPelaaja(new Pelaaja("kolmas"));
                    poyta.lisaaPelaaja(new Pelaaja("neljäs"));
                    break;
                }
            } catch (Exception e) {
                System.out.println("Virheellinen syöte.");
            }
        }
        return poyta;
    }

    private static void voitto(Poyta poyta) {
        Pelaaja apu = poyta.getTamanVuoronPelaaja();
                
        System.out.println("Pelaaja: " +apu.getNimi()+ " voitti pelin!");
    }

}
