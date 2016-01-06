/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Poyta;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ritakosk
 */
public class MuuLogiikkaTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of tulostaOhjeet method, of class MuuLogiikka.
     */
    @Test
    public void testTulostaOhjeet() {
        System.out.println("tulostaOhjeet");
        MuuLogiikka.tulostaOhjeet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pelaaGUI method, of class MuuLogiikka.
     */
    @Test
    public void testPelaaGUI() {
        System.out.println("pelaaGUI");
        MuuLogiikka.pelaaGUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of luoPelaajatGUI method, of class MuuLogiikka.
     */
    @Test
    public void testLuoPelaajatGUI() {
        System.out.println("luoPelaajatGUI");
        int luku = 0;
        MuuLogiikka.luoPelaajatGUI(luku);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of voittoGUI method, of class MuuLogiikka.
     */
    @Test
    public void testVoittoGUI() {
        System.out.println("voittoGUI");
        MuuLogiikka.voittoGUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lopeta method, of class MuuLogiikka.
     */
    @Test
    public void testLopeta() {
        System.out.println("lopeta");
        MuuLogiikka.lopeta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of luoPelaajaNimelta method, of class MuuLogiikka.
     */
    @Test
    public void testLuoPelaajaNimelta() {
        System.out.println("luoPelaajaNimelta");
        String nimi = "";
        MuuLogiikka.luoPelaajaNimelta(nimi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoyta method, of class MuuLogiikka.
     */
    @Test
    public void testGetPoyta() {
        System.out.println("getPoyta");
        Poyta expResult = null;
        Poyta result = MuuLogiikka.getPoyta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLukija method, of class MuuLogiikka.
     */
    @Test
    public void testGetLukija() {
        System.out.println("getLukija");
        Scanner expResult = null;
        Scanner result = MuuLogiikka.getLukija();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOdota method, of class MuuLogiikka.
     */
    @Test
    public void testGetOdota() {
        System.out.println("getOdota");
        int expResult = 0;
        int result = MuuLogiikka.getOdota();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of odota method, of class MuuLogiikka.
     */
    @Test
    public void testOdota() {
        System.out.println("odota");
        MuuLogiikka.odota();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVuoro method, of class MuuLogiikka.
     */
    @Test
    public void testGetVuoro() {
        System.out.println("getVuoro");
        Vuoro expResult = null;
        Vuoro result = MuuLogiikka.getVuoro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nollaaPeli method, of class MuuLogiikka.
     */
    @Test
    public void testNollaaPeli() {
        System.out.println("nollaaPeli");
        MuuLogiikka.nollaaPeli();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
