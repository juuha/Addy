/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Pakka;
import addykorttipeligroupid.addykorttipeli.Pelaaja;
import addykorttipeligroupid.addykorttipeli.Poyta;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ritakosk
 */
public class MuuLogiikkaTest {
    
    Poyta poyta;
    
    public MuuLogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        poyta = new Poyta(new Pakka());
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of pelaaGUI method, of class MuuLogiikka.
     */
    @Test
    public void testPelaa() {
        MuuLogiikka.getPoyta().tyhjennaPoyta();
        MuuLogiikka.pelaa();
        assertEquals(false, MuuLogiikka.getVuoro().getPoyta().onkoEkaVuoro());
    }

    /**
     * Test of luoPelaajatGUI method, of class MuuLogiikka.
     */
    @Test
    public void testLuoPelaajat() {
        MuuLogiikka.luoPelaajat(2);
        assertEquals(2, MuuLogiikka.getPoyta().getPelaajat().size());
    }

  

    
    /**
     * Test of luoPelaajaNimelta method, of class MuuLogiikka.
     */
    @Test
    public void testLuoPelaajaNimelta() {
        MuuLogiikka.luoPelaajaNimelta("moi");
        assertEquals("moi", MuuLogiikka.getPoyta().getPelaajat().get(0).getNimi());
    }

    /**
     * Test of getPoyta method, of class MuuLogiikka.
     */
    @Test
    public void testGetPoyta() {
        assertEquals(0, MuuLogiikka.getPoyta().getPelaajat().size());
    }

    

    /**
     * Test of getOdota method, of class MuuLogiikka.
     */
    @Test
    public void testGetOdota() {
        assertEquals(0, MuuLogiikka.getOdota());
    }
    
    /**
     * Test of getOdota method, of class MuuLogiikka.
     */
    @Test
    public void testGetOdota2() {
        MuuLogiikka.luoPelaajat(2);
        assertEquals(2, MuuLogiikka.getOdota());
    }

    /**
     * Test of odota method, of class MuuLogiikka.
     */
    @Test
    public void testOdota() {
        MuuLogiikka.luoPelaajat(2);
        MuuLogiikka.odota();
        assertEquals(1, MuuLogiikka.getOdota());
        
    }

    /**
     * Test of getVuoro method, of class MuuLogiikka.
     */
    @Test
    public void testGetVuoro() {
        MuuLogiikka.getPoyta().lisaaPelaaja(new Pelaaja("moro"));
        MuuLogiikka.getPoyta().lisaaPelaaja(new Pelaaja("joro"));
        MuuLogiikka.pelaa();
        assertEquals("moro", MuuLogiikka.getVuoro().getPoyta().getTamanVuoronPelaaja().getNimi());
        
    }

    /**
     * Test of nollaaPeli method, of class MuuLogiikka.
     */
    @Test
    public void testNollaaPeli() {
        MuuLogiikka.getPoyta().lisaaPelaaja(new Pelaaja("moi"));
        MuuLogiikka.nollaaPeli();
        assertEquals(0, MuuLogiikka.getPoyta().getPelaajat().size());
    }
    
}
