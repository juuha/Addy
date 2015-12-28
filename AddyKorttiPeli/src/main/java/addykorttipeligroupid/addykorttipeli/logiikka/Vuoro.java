package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Kortti;
import addykorttipeligroupid.addykorttipeli.Poyta;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Vuoro {

    private Poyta poyta;
    private Scanner lukija;
    private int voitto = 0;

    public Vuoro(Scanner lukija, Poyta poyta) {
        this.poyta = poyta;
        this.lukija = lukija;
    }

    public void aloitaPeli() {
        poyta.setVuoroAlussa();
        poyta.getPakka().jaaKortit(poyta);
    }

    public int vuoro() {
        valmistelut();
        while (true) {
            System.out.println("Pöydän päällimmäinen kortti on: " + poyta.getPaallimmainen());
            System.out.println(poyta.getTamanVuoronPelaaja().kadessaOlevatKortit());
            System.out.println("Mitä tehdään? (pelaa/nosta/lopeta vuoro).");
            String komento = lukija.nextLine();
            if (komento.equals("nosta")) {
                nostaKortti();
            } else if (komento.equals("lopeta vuoro")) {
                if (lopetavuoro()) {
                    break;
                }
            } else if (komento.equals("pelaa")) {
                if (pelaa()) {
                    break;
                }
            } else {
                System.out.println("\nVirheellinen syöte. Anna jokin seuraavista"
                        + " komennoista (pelaa/nosta/lopeta vuoro). ");
            }
        }
        jalkivalmistelut();

        return voitto;
    }

    private void jalkivalmistelut() {
        if (poyta.getTamanVuoronPelaaja().montaKorttiaKadessa() == 0) {
            voitto = 1;
        }

        if (poyta.onkoEkaVuoroOhi() == false) {
            poyta.ekaVuoroOhi();
        }

        poyta.setTamanVuoronPelaaja();
    }

    private void valmistelut() {
        voitto = 0;
        poyta.getTamanVuoronPelaaja().nollaaKorttienNostot();
        boolean apu = poyta.onkoEkaVuoroOhi();
        if (apu = true) {
            System.out.println(poyta.getViimeVuorollaPelattu());
        }
        System.out.println("Paina palautusnäppäintä (enteriä) aloittaaksesi pelaaja "
                + poyta.getTamanVuoronPelaaja().getNimi() + ":n vuoro.");
        lukija.nextLine();

    }

    private boolean pelaa() {
        while (true) {
            System.out.println("Valitse kortteja muodossa \"hertta 2, hertta 3\""
                    + " tai palaa komennolla \"palaa\".");
            String komento = lukija.nextLine();
            if (komento.equals("palaa")) {
                return false;
            } else {
                ArrayList<Kortti> pelattavatKortit = valitseKortit(komento);
                if (pelattavatKortit != null) {
                    if (voikoKortitPelata(pelattavatKortit)) {   // ongelma!
                        System.out.println("3");
                        poyta.setPaallimmainen(pelattavatKortit.get(0));
                        for (Kortti kortti : pelattavatKortit) {
                            System.out.println("4");
                            poyta.getTamanVuoronPelaaja().otaKorttiKadesta(kortti.getMaa(), kortti.getArvo());
                            poyta.laitaPoydallaOleviinKortteihin(kortti);
                            break;
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Kortti> valitseKortit(String komento) {
        ArrayList<Kortti> pelattavatKortit = new ArrayList();
        String[] kortit = komento.split(", ");
        for (int i = 1; i <= kortit.length; i++) {
            for (String annettuKortti : kortit) {
                String[] maaJaArvo = annettuKortti.split(" ");
                try {
                    Kortti apuKortti = new Kortti(maaJaArvo[0],
                            Integer.parseInt(maaJaArvo[1]));
                    if (apuKortti == poyta.getTamanVuoronPelaaja()
                            .getKorttiArvolta(apuKortti.getMaa(),
                                    apuKortti.getArvo())) {
                        pelattavatKortit.add(apuKortti);
                    }
                } catch (Exception e) {
                    System.out.println("\nVirheellinen syöte.");
                    return null;
                }
            }
        }
        if (olikoLaillinenSiirto(pelattavatKortit)) return null;
        
        return pelattavatKortit;
    }

    private boolean olikoLaillinenSiirto(ArrayList<Kortti> pelattavatKortit) {
        if (pelattavatKortit.size() > 3) {
            System.out.println("Pelasit liikaa kortteja.");
            return true;
        }
        
        Set<Kortti> set = new HashSet<Kortti>(pelattavatKortit);
        if (set.size() < pelattavatKortit.size()) {
            System.out.println("Et voi pelata samaa korttia monta kertaa");
            return true;
        }
        
        return false;
    }

    private void nostaKortti() {
        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() >= 3) {
            System.out.println("\nNostit jo 3 korttia tällä vuorolla.");
        } else {
            Kortti apuKortti = poyta.getPakka().otaEka();
            poyta.getTamanVuoronPelaaja().nostaKortti(apuKortti);
            System.out.println("");
        }
    }

    private boolean lopetavuoro() {
        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() == 3) {
            return true;
        } else {
            System.out.println("\nEt ole nostanut kolmea kertaa tällä vuorolla.");
            return false;
        }
    }

    private boolean voikoKortitPelata(ArrayList<Kortti> pelattavatKortit) {
        int summa = 0;
        for (Kortti kortti : pelattavatKortit) {
            System.out.println(kortti);
            summa += kortti.getArvo();
        }
        while (summa > 9) {
            summa -= 10;
        }
        System.out.println("summa " + summa);
        System.out.println("päällimmäinen " +poyta.getPaallimmainen().getArvo());
        return poyta.getPaallimmainen().getArvo() == summa;
    }
}
