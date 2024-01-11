package org.hbrs.se1.ws23.uebung9.test;

import org.hbrs.se1.ws23.uebung9.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClient {
    ComplexDocument doc3;
    ComplexDocument doc0;
    TextDocument doc2;
    TextDocument doc5;
    GraficDocument doc4;
    @BeforeEach
    public void erstellenUndHinzufuegenDoc () {
        doc0 = new ComplexDocument();
        doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt!", Encoding.UTF8);
        doc3 = new ComplexDocument();
        doc4 = new GraficDocument("localhost:8080");
        doc5 = new TextDocument("Software Engineering I ist eine Vorlesung in den Studiengaengen BIS und BCS", Encoding.UTF32);

        doc3.addDocument(doc5);
        doc3.addDocument(doc4);
        doc0.addDocument(doc3);
        doc0.addDocument(doc2);

    }

    @Test
    public void testeAusgabe () {
        System.out.println(doc0.getTotalBytes());
        System.out.println(doc2.getBytes());
        System.out.println(doc3.getTotalBytes());
        System.out.println(doc4.getBytes());
        System.out.println(doc5.getBytes());

    }
    @Test
    public void testeEnumtype () {
        assertEquals(doc2.encoding.getEncoding(), "UTF-8");
        System.out.println(doc2.encoding.getEncoding());
        assertEquals(doc5.encoding.getEncoding(), "UTF-32");
        System.out.println(doc5.encoding.getEncoding());
    }
}
