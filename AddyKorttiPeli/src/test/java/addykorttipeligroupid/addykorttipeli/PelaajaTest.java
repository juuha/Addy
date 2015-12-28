
package addykorttipeligroupid.addykorttipeli;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    
    private Pelaaja pelaaja;
    
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
        pelaaja = new Pelaaja("Megaman");
        pelaaja.nostaKortti(new Kortti("pata", 1));
        pelaaja.nostaKortti(new Kortti("hertta", 5));
        pelaaja.nostaKortti(new Kortti("jokeri", -5));
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetNimi() {
        assertEquals("Megaman", pelaaja.getNimi());
    }
    
    @Test
    public void testKadessaOlevatKortit() {
        assertEquals("Kädessä on pata 1, hertta 5, jokeri -5.", pelaaja.kadessaOlevatKortit());
    }
    
    @Test
    public void testMontaKorttiaKadessa() {
        assertEquals(3, pelaaja.montaKorttiaKadessa());
    }
    
    @Test
    public void testNostaKortti() {
       pelaaja.nostaKortti(new Kortti("risti", 5));
       assertEquals(4, pelaaja.montaKorttiaKadessa());
    }
    
    @Test
    public void testNollaaKorttienNostot() {
        pelaaja.nollaaKorttienNostot();
        pelaaja.nostaKortti(new Kortti("moi", 5));
        pelaaja.nostaKortti(new Kortti("moi", 5));
        assertEquals(2, pelaaja.getTallaVuorollaNostettu());
        pelaaja.nollaaKorttienNostot();
        assertEquals(0, pelaaja.getTallaVuorollaNostettu());
    }
    
    @Test
    public void testGetKorttiArvolta(){
        Kortti apu = pelaaja.getKorttiArvolta("jokeri", -5);
        assertEquals("jokeri -5", apu.toString());
    }
    
    @Test
    public void testGetKorttiArvoltaEiAnnaVirheellistaVastausta(){
        Kortti apu = pelaaja.getKorttiArvolta("jokeri", 5);
        assertEquals(null, apu);
    }
    
    @Test
    public void testOtaKorttiKadesta(){
        pelaaja.otaKorttiKadesta("jokeri", -5);
        assertEquals(2, pelaaja.montaKorttiaKadessa());
    }
    
    @Test
    public void testGetTallaVuorollaNostettu1(){
        assertEquals(3, pelaaja.getTallaVuorollaNostettu());
    }
    
    @Test
    public void testGetTallaVuorollaNostettu2(){
        pelaaja.nostaKortti(new Kortti("pata", 1));
        pelaaja.nostaKortti(new Kortti("pata", 2));
        assertEquals(5, pelaaja.getTallaVuorollaNostettu());
    }
    
}
