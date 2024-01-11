package org.hbrs.se1.ws23.uebung4.test;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws23.uebung4.UserStory.UserStory;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceStrategyStreamNeu;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hbrs.se1.ws23.uebung4.Container4.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class SoftwareTest {
    /*@Test
    void speichereUndLadeUserStory() throws Exception {
        System.out.println("Teste: Gib 'enter' ein, trage eine User-Story ein, gib dann 'store' ein, um diese Persistenz abzuspeichern.");
        System.out.println("Danach kannst du 'exit' eingeben, um das Programm zu beenden.");

        // Backup von System.in und System.out erstellen
        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;

        try {
            // Mock für System.in erstellen
            ByteArrayInputStream mockInput = new ByteArrayInputStream("enter\nTestID\nTestBeschreibung\nTestAkzeptanzkriterium\n4\n4\n2\n2\nTestProjekt\nstore\nexit\n".getBytes());
            System.setIn(mockInput);

            // Mock für System.out erstellen
            ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockOutput));

            // Container erstellen
            Container con = Container.getInstance();

            // PersistenceStrategy und Location setzen (wie zuvor)

            // Test durchführen
            con.startEingabe();

            // Hier können Assertions eingefügt werden, um zu überprüfen, ob die erwarteten Aktionen ausgeführt wurden.

            // Beispiel: Überprüfen der Ausgabe
            String output = mockOutput.toString();
            System.out.println(output);
            // Füge hier Assertions für die erwartete Ausgabe hinzu
        } finally {
            // Original System.in und System.out wiederherstellen
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }*/
    @Test
    void speichereUserStory() throws Exception {
        System.out.println("Teste so: Gib 'enter' ein. Trage eine User-Story ein und gib dann 'store' ein um diese persistenz abzuspeichern.");
        System.out.println("Danach können sie 'exit' eingeben um das Programm zu beenden");
        Container con = Container.getInstance();
        PersistenceStrategy<UserStory> strategy = new PersistenceStrategyStreamNeu<>();
        ((PersistenceStrategyStreamNeu<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/test/testdata.ver");
        con.strategy = strategy;
        con.startEingabe();
    }
    @Test
    void ladeUserStory() throws Exception {
        System.out.println("Das Programm startet jetzt erneut. Rufe durch 'load' die eben gespeicherte User-Story wieder auf");
        System.out.println("Durch den befehl 'dump' kannst du dir die User-Story ausgeben lassen und überprüfen ob diese richtig ist.");
        System.out.println("Gebe dann erneut 'exit' ein um das Programm zu verlassen");
        Container con = Container.getInstance();
        PersistenceStrategy<UserStory> strategy = new PersistenceStrategyStreamNeu<>();
        ((PersistenceStrategyStreamNeu<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/test/testdata.ver");
        con.strategy = strategy;
        con.startEingabe();
    }

    @Test
    void testeSuche() throws Exception {
        System.out.println("Um die Suchfunktion zu testen erstelle nun mehrere User-Stories und mit mehrfacher benutzung des 'enter'-Befehls");
        System.out.println("Danach lassen sich die User-Stories mithilfe ihres Projekts und dem befehl 'searh (project)' suchen und ausgeben");
        System.out.println("Nach überprüfen der richtigen Search-Ausgabe kann nun das Programm mit 'exit' beendet werden");
        Container con = Container.getInstance();
        PersistenceStrategy<UserStory> strategy = new PersistenceStrategyStreamNeu<>();
        ((PersistenceStrategyStreamNeu<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/test/testdata.ver");
        con.strategy = strategy;
        con.startEingabe();
    }

}
