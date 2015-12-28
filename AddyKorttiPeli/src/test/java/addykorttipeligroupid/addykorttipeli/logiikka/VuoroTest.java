
package addykorttipeligroupid.addykorttipeli.logiikka;

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
        vuoro = new Vuoro(lukija, poyta);
        
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

    
    

    
    
    
}
