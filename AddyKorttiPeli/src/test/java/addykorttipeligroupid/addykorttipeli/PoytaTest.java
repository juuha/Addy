
package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PoytaTest {
    private Poyta poyta;
    private Pakka pakka;
    
    
    public PoytaTest() {
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
    }
    
    @After
    public void tearDown() {
    }

   
    

    
    @Test
    public void testGetJaSetPaallimmainen() {
        poyta.setPaallimmainen(new Kortti("hertta", 5));
        assertEquals("hertta 5", poyta.getPaallimmainen().toString());
    }

    
    @Test
    public void testLisaaPelaaja1() {
        assertEquals(0, poyta.getPelaajat().size());
    }
    
    @Test
    public void testLisaaPelaaja2() {
        poyta.lisaaPelaaja(new Pelaaja("Jims"));
        assertEquals(1, poyta.getPelaajat().size());
        
    }
    
    

    @Test
    public void testGetTamanVuoronPelaaja() {
        poyta.lisaaPelaaja(new Pelaaja("Jims"));
        poyta.lisaaPelaaja(new Pelaaja("Megaman"));
        poyta.lisaaPelaaja(new Pelaaja("67"));
        poyta.setVuoroAlussa();
        poyta.setTamanVuoronPelaaja();
        assertEquals("Megaman", poyta.getTamanVuoronPelaaja().getNimi());
    }
    
    @Test
    public void testSetVuoroAlussa() {
        poyta.lisaaPelaaja(new Pelaaja("Jims"));
        poyta.lisaaPelaaja(new Pelaaja("Megaman"));
        poyta.lisaaPelaaja(new Pelaaja("67"));
        poyta.setVuoroAlussa();
        assertEquals("Jims", poyta.getTamanVuoronPelaaja().getNimi());
    }
    

    
    @Test
    public void testSetSeuraavanVuoronpelaaja() {
        poyta.lisaaPelaaja(new Pelaaja("Jims"));
        poyta.lisaaPelaaja(new Pelaaja("Megaman"));
        poyta.lisaaPelaaja(new Pelaaja("67"));
        poyta.setVuoroAlussa();
        assertEquals("Megaman", poyta.getSeuraavanVuoronPelaaja().getNimi());
    }

    @Test
    public void testOnkoEkaVuoro() {
        assertEquals(true, poyta.onkoEkaVuoro());
    }
    
    @Test
    public void testEkaVuoroOhi() {
        poyta.ekaVuoroOhi();
        assertEquals(false, poyta.onkoEkaVuoro());
    }
    
    @Test
    public void testGetViimeVuorollaPelattu() {
        assertEquals("", poyta.getViimeVuorollaPelattu());
    }
    
    @Test
    public void testSetViimeVuorollaPelattu() {
        poyta.setViimeVuorollaPelattu("risti 5");
        assertEquals("risti 5", poyta.getViimeVuorollaPelattu());
    }
    
    @Test
    public void testGetPelaajat() {
        poyta.lisaaPelaaja(new Pelaaja("Jims"));
        poyta.lisaaPelaaja(new Pelaaja("Megaman"));
        String apu = "";
        for (Pelaaja pel : poyta.getPelaajat()) {
            apu += pel.getNimi();
        }
        assertEquals("JimsMegaman", apu);
    }
    
    @Test
    public void testGetPoydallaOlevatKortit() {
        assertEquals(0, poyta.getPoydallaOlevatKortit().size());
        
    }
    
    @Test
    public void testLaitaPoydallaOleviinKortteihin() {
        poyta.laitaPoydallaOleviinKortteihin(new Kortti("hertta", 1));
        poyta.laitaPoydallaOleviinKortteihin(new Kortti("hertta", 2));
        poyta.laitaPoydallaOleviinKortteihin(new Kortti("hertta", 3));
        poyta.laitaPoydallaOleviinKortteihin(new Kortti("hertta", 4));
        assertEquals(4, poyta.getPoydallaOlevatKortit().size());
        
    }
    
    
}
