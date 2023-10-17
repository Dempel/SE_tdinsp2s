## Antworten zu den Fragen von Übungsblatt 1



### Aufgabe 1)

 a) Durch das Erstellen einer weiteren Klasse namens "Translatorfactory" 
    im "control" Package und dem dortigen Erstellen einer static Methode, welche
    ein neues Obejekt der Klasse "GermanTranslator" erzeugt, kann man diese Aufgabe lösen.
    So umgeht man die Erstellung einer Intsanz innerhalb der Klasse Client.
<br>
<br>
b)  Anwendung des Factory Methode Pattern (Kapitel 6; [GoF])
<br>
<br>
c)  Im Source Code des Interfaces könnte gegebenenfalls ein "public" hinzugefügt werden, 
    um sicherzustellen, dass Client auch einen Zugriff die Schnittstelle hat und kein Compilerfeher passiert.
<br>
<br>

### Aufgabe 3)
a)  Eine separate Testklasse ist isoliert und übersichtlich. Es trennt die Anwendungs-
    und Testumgebungen voneinander und man kann auf beides leichter zugreifen und Änderungen individuell vornehmen.
    Außerdem kann man so mithilfe einer Testklasse mehrere unabhängige Klassen auf einmal testen.
<br>
<br>
b)  Der Sinn einer Äquivalenzklasse bei Blackbox-Tests ist der, dass es genügt einen Repräsentanten dieser Klasse
    zu testen, da alle anderen Input-Möglichkeiten aus dieser Äquivalenzklasse ähnliche oder sogar gleiche Ergebnisse liefern würden. 
    Es genügt also meistens jeweils einen Repräsentanten pro Äquivalenzklasse zu testen.
<br>
<br>
c)  Die Klasse Client hat keinen Rückgabewert und Blackbox-Tests werten
    ausschließlich Inputs und Outputs aus, somit ist die Klasse auf diese 
    Art nicht testbar.
<br>
<br>






