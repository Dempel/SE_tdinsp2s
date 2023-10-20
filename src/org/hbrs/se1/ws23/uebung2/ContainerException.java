package org.hbrs.se1.ws23.uebung2;

public class ContainerException extends Exception {

    public ContainerException() {
        super("Das Member-Objekt mit dieser ID ist bereits vorhanden!");
    }

    public ContainerException(String fehlermeldung) {
        super(fehlermeldung);
    }
}