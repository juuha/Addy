
package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Kortti;
import addykorttipeligroupid.addykorttipeli.Pakka;
import addykorttipeligroupid.addykorttipeli.Pelaaja;
import addykorttipeligroupid.addykorttipeli.Poyta;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VuoroTest {
    
    private Pakka pakka;
    private Poyta poyta;
    private Vuoro vuoro;
    private Scanner lukija;
    
    public VuoroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pakka = new Pakka();
        poyta = new Poyta(pakka);
        poyta.lisaaPelaaja(new Pelaaja("Batman"));
        poyta.lisaaPelaaja(new Pelaaja("Superman"));
        poyta.lisaaPelaaja(new Pelaaja("Wonderwoman"));
        lukija = new Scanner(System.in);
        vuoro = new Vuoro(poyta);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAloitaPeli1() {
        vuoro.aloitaPeli();
        Pelaaja apu = poyta.getTamanVuoronPelaaja();
        assertEquals("Batman", apu.getNimi());
    }
    
    @Test
    public void testAloitaPeli2() {
        vuoro.aloitaPeli();
        int apu = poyta.getTamanVuoronPelaaja().montaKorttiaKadessa();
        assertEquals(7, apu);
    }
    
    @Test
    public void testVuoro() {
        
    }
    
    @Test
    public void testGetVoitto() {
        assertEquals(0, vuoro.getVoitto());
    }
    
    @Test
    public void testValmistelut() {
        vuoro.aloitaPeli();
        vuoro.getPoyta().getTamanVuoronPelaaja().nostaKortti(new Kortti("Hertta", 5));
        vuoro.valmistelut();
        assertEquals(0, vuoro.getPoyta().getTamanVuoronPelaaja().getTallaVuorollaNostettu());
    }

    
    @Test
    public void testJalkivalmistelut() {
        vuoro.aloitaPeli();
        vuoro.jalkivalmistelut();
        assertEquals("Superman", vuoro.getPoyta().getTamanVuoronPelaaja().getNimi());
    }
    
    @Test
    public void testJalkivalmistelut2() {
        vuoro.aloitaPeli();
        vuoro.getPoyta().setTamanVuoronPelaaja();
        vuoro.jalkivalmistelut();
        assertEquals(true, vuoro.getPoyta().onkoEkaVuoro());
    }

    
    @Test
    public void testNostaKortti() {
        vuoro.aloitaPeli();
        vuoro.getPoyta().getTamanVuoronPelaaja().nostaKortti(new Kortti("jep", 5));
        vuoro.getPoyta().getTamanVuoronPelaaja().nostaKortti(new Kortti("jep", 6));
        vuoro.getPoyta().getTamanVuoronPelaaja().nostaKortti(new Kortti("jep", 7));
        assertEquals(true, vuoro.nostaKortti());
    }
    
    
    
    @Test
    public void testNostaKorttiGUI3() {
        vuoro.aloitaPeli();
        vuoro.valmistelut();
        assertEquals(0, vuoro.getPoyta().getTamanVuoronPelaaja().getTallaVuorollaNostettu());
    }

    
    @Test
    public void testGetPoyta() {
        assertEquals("Superman", vuoro.getPoyta().getPelaajat().get(1).getNimi());
    }

    
    

    
    

    
    
    
}
