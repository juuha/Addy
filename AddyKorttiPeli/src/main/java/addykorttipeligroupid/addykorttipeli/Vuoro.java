package addykorttipeligroupid.addykorttipeli;

import java.util.Scanner;

public class Vuoro {

    private Poyta poyta;
    private Scanner lukija;

    public Vuoro(Scanner lukija, Poyta poyta) {
        this.poyta = poyta;
        this.lukija = lukija;
    }

    void aloitaPeli() {
        poyta.setVuoroAlussa();
        poyta.getPakka().jaaKortit(poyta);
    }

    public int vuoro() {
        int voitto = 0;
        poyta.getTamanVuoronPelaaja().nollaaKorttienNostot();
        boolean apu = poyta.onkoEkaVuoroOhi();
        if (apu = true) {
            System.out.println(poyta.getViimeVuorollaPelattu());
        }
        while (true) {
            System.out.println("Pöydän päällimmäinen kortti on: " + poyta.getPaallimmainen());
            System.out.println(poyta.getTamanVuoronPelaaja().kadessaOlevatKortit());
            System.out.println("Mitä tehdään? (pelaa/nosta/lopeta vuoro).");
            String komento = lukija.nextLine();
            if (komento.equals("nosta")) {
                if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() >= 3) {
                    System.out.println("Nostit jo 3 korttia tällä vuorolla.");
                } else {
                    Kortti apuKortti = poyta.getPakka().otaEka();
                    poyta.getTamanVuoronPelaaja().nostaKortti(apuKortti);
                }
            } else if (komento.equals("lopeta vuoro")) {
                if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() == 3) {
                    // ei valmis
                    break;
                } else {
                    System.out.println("Et ole nostanut kolmea kertaa tällä vuorolla.");
                }
            } else if (komento.equals("pelaa")) {
                // ei valmis
                break;
            }
        }

        if (poyta.getTamanVuoronPelaaja().montaKorttiaKadessa() == 0) {
            voitto = 1;
        }

        if (poyta.onkoEkaVuoroOhi() == false) {
            poyta.ekaVuoroOhi();
        }

        poyta.setTamanVuoronPelaaja();

        return voitto;
    }

}
