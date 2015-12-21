
package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    
    private Pelaaja testi;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi = new Pelaaja("Megaman");
        testi.nostaKortti(new Kortti("pata", 1));
        testi.nostaKortti(new Kortti("hertta", 5));
        testi.nostaKortti(new Kortti("jokeri", -5));
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetNimi() {
        assertEquals("Megaman", testi.getNimi());
    }
    
    @Test
    public void testKadessaOlevatKortit() {
        assertEquals("Kädessä on pata 1, hertta 5, jokeri -5.", testi.kadessaOlevatKortit());
    }
    
    @Test
    public void testMontaKorttiaKadessa() {
        assertEquals(3, testi.montaKorttiaKadessa());
    }
    
    @Test
    public void testOtaKorttiKadesta() {
       testi.nostaKortti(new Kortti("risti", 5));
       assertEquals(4, testi.montaKorttiaKadessa());
    }
    
    @Test
    public void testNollaaKorttienNostot() {
        testi.nollaaKorttienNostot();
        testi.nostaKortti(new Kortti("moi", 5));
        testi.nostaKortti(new Kortti("moi", 5));
        assertEquals(2, testi.getTallaVuorollaNostettu());
        testi.nollaaKorttienNostot();
        assertEquals(0, testi.getTallaVuorollaNostettu());
    }
    
}
