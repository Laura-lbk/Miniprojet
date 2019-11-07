/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author talend
 */
public class PourcentageServiceImplTest {
    
    public PourcentageServiceImplTest() {
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
     * Test of RemiseMontant method, of class PourcentageServiceImpl.
     */
    
    @Test
    public void testRemiseMontant() {
        System.out.println("RemiseMontant");
        Integer p_montant = 100;
        Integer p_pourcent = 10;
        PourcentageServiceImpl instance = new PourcentageServiceImpl();
        Integer expResult = 10;
        Integer result = instance.RemiseMontant(p_montant, p_pourcent);
        assertEquals(expResult, result);
    }

    /**
     * Test of MontantAvantRemise method, of class PourcentageServiceImpl.
     */
    
    @Test
    public void testMontantAvantRemise() {
        System.out.println("MontantAvantRemise");
        Integer p_montant = 25;
        Integer p_pourcent = 100;
        PourcentageServiceImpl instance = new PourcentageServiceImpl();
        Integer expResult = 100;
        Integer result = instance.MontantAvantRemise(p_montant, p_pourcent);
        assertEquals(expResult, result);

    }
    
}
