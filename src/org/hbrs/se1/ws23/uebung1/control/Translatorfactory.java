package org.hbrs.se1.ws23.uebung1.control;

public class Translatorfactory {
    public static GermanTranslator createGermanTranslator(){
        return new GermanTranslator();
    }
}
