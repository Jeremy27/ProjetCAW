/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univ.lehavre.caw.Outils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeremy
 */
public class TestCaractere {
    
    public TestCaractere() {
    }
    
    @Test
    public void testGetDecimal() {
        Caractere caractere1 = new Caractere('a');
        assertEquals(97, caractere1.getDecimal());
        
        Caractere caractere2 = new Caractere('*');
        assertEquals(42, caractere2.getDecimal());
        
        Caractere caractere3 = new Caractere(' ');
        assertEquals(32, caractere3.getDecimal());
    }
    
    @Test
    public void testGetHex() {
        Caractere caractere1 = new Caractere('a');
        assertEquals("61", caractere1.getHex());
        
        Caractere caractere2 = new Caractere('*');
        assertEquals("2a", caractere2.getHex());
        
        Caractere caractere3 = new Caractere(' ');
        assertEquals("20", caractere3.getHex());
    }
    
    @Test
    public void testGetHtml() {
        Caractere caractere = new Caractere('é');
        assertEquals("&eacute;", caractere.getHtml());
        
        Caractere caractere2 = new Caractere('à');
        assertEquals("&agrave;", caractere2.getHtml());
        
        Caractere caractere3 = new Caractere(' ');
        assertEquals("&nbsp;", caractere3.getHtml());
    }
    
    @Test
    public void testUnicode() {
        Caractere caractere = new Caractere('a');
        assertEquals("\\u61", caractere.getUnicode());
        
        Caractere caractere2 = new Caractere('*');
        System.out.println("============================"+caractere2.getUnicode());
        assertEquals("\\u2a", caractere2.getUnicode());
        
        Caractere caractere3 = new Caractere(' ');
        assertEquals("\\u20", caractere3.getUnicode());
    }
}
