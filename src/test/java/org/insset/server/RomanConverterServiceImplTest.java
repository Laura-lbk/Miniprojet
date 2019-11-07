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
public class RomanConverterServiceImplTest {
    
    public RomanConverterServiceImplTest() {
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
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDateYears() {
        System.out.println("convertDateYears");
        String nbr = "25/01/2019";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "XV/III/MX";
        String result = instance.convertDateYears(nbr);
        assertEquals(expResult, result);
 
    }

    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertArabeToRoman() {
        System.out.println("convertArabeToRoman");
        Integer nbr = 14;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "xxxvi";
        String result = instance.convertArabeToRoman(nbr);
        assertEquals(expResult, result);

    }

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
        System.out.println("convertRomanToArabe");
        String nbr = "XIV";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        Integer expResult = 0;
        Integer result = instance.convertRomanToArabe(nbr);
        assertEquals(expResult, result);}


    /**
     * Test of giveValChar method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testGiveValChar() {
        System.out.println("giveValChar");
        String lettre = "0";
        int expResult = 0;
        int result = RomanConverterServiceImpl.giveValChar(lettre);
        assertEquals(expResult, result);
  
    }
    
}
