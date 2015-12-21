
package addykorttipeligroupid.addykorttipeli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KorttiTest {
    
    public KorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetArvo() {
        Kortti kortti = new Kortti("Megaman", 15);
        assertEquals(15, kortti.getArvo());
    }

    @Test
    public void testGetMaa() {
        Kortti kortti = new Kortti("Megaman", 15);
        assertEquals("Megaman", kortti.getMaa());
    }

    
    @Test
    public void testToString() {
        Kortti kortti = new Kortti("Megaman", 15);
        assertEquals("Megaman 15", kortti.toString());
    }
    
}
