/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univ.lehavre.caw.Outils;

/**
 *
 * @author brokep
 */
public class Caractere {
    private final char _caractere;
    private final String _hex;
    private final String _html;
    private final String _unicode;
    private final int _decimal;
    
    public Caractere(char c) {
        _caractere = c;
        _decimal = Character.getNumericValue(_caractere);
        _hex = Integer.toHexString(_decimal);
        _html = "&#" + _decimal + ";";
        _unicode = "\\u" + _hex;
    }

    /**
     * @return the _hex
     */
    public String getHex() {
        return _hex;
    }

    /**
     * @return the _html
     */
    public String getHtml() {
        return _html;
    }

    /**
     * @return the _unicode
     */
    public String getUnicode() {
        return _unicode;
    }

    /**
     * @return the _decimal
     */
    public int getDecimal() {
        return _decimal;
    }
    
    
}
