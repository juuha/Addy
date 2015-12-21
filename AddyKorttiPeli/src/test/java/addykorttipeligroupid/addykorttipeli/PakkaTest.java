
package addykorttipeligroupid.addykorttipeli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PakkaTest {

    private Pakka testi;
    
    public PakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi = new Pakka("ilmansekotusta");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testOtaEka() {
        Kortti kortti = testi.otaEka();
        assertEquals("hertta 1",kortti.toString());
    }
    
    @Test
    public void testMontaPakassa() {
        testi.otaEka();
        testi.otaEka();
        assertEquals(50,testi.montaPakassa());
    }
    
}
