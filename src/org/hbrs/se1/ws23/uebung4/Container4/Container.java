package org.hbrs.se1.ws23.uebung4.Container4;



import org.hbrs.se1.ws23.uebung4.UserStory.UserStory;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung4.persistence.PersistenceStrategyStreamNeu;

import java.io.Serializable;
import java.util.*;

public class Container<T extends UserStory> {

	/*
	 * Interne ArrayList zur Abspeicherung der Objekte
	 * Alternative: HashMap oder Set. HashMap hat vor allem Probleme 
	 * bei der Bewahrung der Konsistenz vom Key und Value (siehe TestStore, letzter Test)
	 */
	private List<T> liste = new ArrayList<T>();

	private static Container instance = new Container();
	public PersistenceStrategy<T> strategy;


	Container(){
		liste = new ArrayList<T>();
	}
	public static Container getInstance() {
		return instance;
	}


	public void store() throws PersistenceException {
		if (strategy == null) {
			throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Strategie gesetzt!");
		}
		strategy.save(liste);
	}
	public void load() throws PersistenceException {
		if (strategy == null) {
			throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Strategie gesetzt!");
		}
		liste = (ArrayList<T>)strategy.load();

	}
	public List<T> getCurrentList() {
		return liste;

	}
	public void deleteAll() {
		while (size() > 0) {
			liste.remove(0);
		}
	}

	/*
	 * Methode zum Hinzufuegen einer UserStory.
	 * @throws ContainerException
	 */

	public void addUserStory ( T userStory ) throws ContainerException {
		if ( contains(userStory) == true ) {
			ContainerException ex = new ContainerException("ID bereits vorhanden!");
			throw ex;
		}
		liste.add(userStory);
	}
	
	/*
	 * Methode zur Ueberpruefung, ob ein UserStory-Objekt in der Liste enthalten ist
	 * 
	 */
	private boolean contains(T userStory) {
		int ID = userStory.getid();
		for (UserStory us : liste) {
			if ( us.getid() == ID ) {
				return true;
			}
		}
		return false;
	}
		
		// liste.contains(r), falls equals-Methode in UserStory ueberschrieben.

	/*
	 * Methode zum Loeschen einer UserStory
	 * In Praxis durchaus verwendet: C-Programme; beim HTTP-Protokoll; SAP-Anwendung (R3); Mond-Landung ;-)
	 * 
	 */
	public String deleteUserStory( Integer id ) {
		T rec = (T) getUserStory( id );
		if (rec == null) return " nicht enthalten - ERROR"; else {
			liste.remove(rec);
			return "UserStory mit der ID " + id + " konnte geloescht werden";
		}
	}
	
	/*
	 * Methode zur Bestimmung der Anzahl der von UserStory-Objekten
	 * Aufruf der Methode size() aus List
	 */
	public int size(){
		return liste.size();
	}


	//Interne Methode zur Ermittlung einer UserStory

	private UserStory getUserStory(int id) {
		for ( UserStory userStory : liste) {
			if (id == userStory.getid() ){
				return userStory;
			}
		}
		return null;
	}
	public void startEingabe() throws ContainerException, Exception {
		String strInput = null;

		// Initialisierung des Eingabe-View
		Scanner scanner = new Scanner( System.in );

		while ( true ) {
			// Ausgabe eines Texts zur Begruessung
			System.out.println("UserStory-Tool V1.0 by Julius P. (dedicated to all my friends)");

			System.out.print( "> "  );

			strInput = scanner.nextLine();

			// Extrahiert ein Array aus der Eingabe
			String[] strings = strInput.split(" ");

			// Help-Befehl: help (Anzeige aller möglichen Befehle)
			if (strings[0].equals("help")) {
				help();
			}
			// Dump-Befehl: dump (eine nach den berechneten Priorisierungen sortierte Ausgabe der User Stories inklusive aller eingegeben Angaben).
			if (strings[0].equals("dump")) {
				startAusgabe();
			}
			// Enter-Befehl: enter (Eingabe einer User Story, nur Ablage in den RAM-Speicher, also in die Klasse Container
			if (strings[0].equals("enter")) {
				enter(scanner);
			}
			// Store-Befehl: store (Persistentes Abspeichern von User Stories aus einem ContainerObjekt auf einen Datenträger (vgl. Übung Nr. 3-2)
			if (strings[0].equals("store") ) {
				store();
			}
			// Load-Befehl: load (Laden von User Stories von einem Datenträger in ein ContainerObjekt
			if (strings[0].equals("load") ) {
				load();
			}
			// Search-Befehl: search (Suche nach User Stories nach Projekten; Suchwort (= Bezeichnung des Projektes) wird dabei als Parameter übergeben);
			if (strings[0].equals("search")) {
				for (T e: liste) {
					if(e.getProject().equals(strings[1])) {
						System.out.println(e.toString());
					}
				}
			}


			if (strings[0].equals("exit")) {
				scanner.close();
				break;
			}
		} // Ende der Schleife
	}

	public void startAusgabe() {

		liste.sort(Comparator.comparing(UserStory ::getPrio).reversed());
		for (UserStory story : liste) {
			System.out.println(story);
		}
	}
	public void help() {
		System.out.println("Folgende Befehle stehen zur Verfuegung:" + "\n" +
				"help "+ "\t" + "[Auflisten aller Befehle]" + "\n" +
				"enter "+ "\t" + "[Eingabe einer User Story]" + "\n" +
				"store "+ "\t" + "[Abspeichern von User Stories]" + "\n" +
				"load "+ "\t" + "[Laden von User Stories]" + "\n" +
				"dump "+ "\t" + "[sortierte Ausgabe der User Stories]" + "\n" +
				"search "+ "\t" + "[Suche nach User Stories nach Projekten]" + "\n" +
				"exit "+ "\t" + "[Verlassen der Anwendung]");
	}
	public void enter(Scanner sc) throws ContainerException {
		System.out.println("ID:"); int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Beschreibung:"); 		String titel = sc.nextLine();
		System.out.println("Akzeptanzkriterium:"); 	String akzeptanzkriterium = sc.nextLine();
		System.out.println("Mehrwert(1-5):"); 		int mehrwert = sc.nextInt(); 	if (mehrwert > 5 || mehrwert < 1) {throw new InputMismatchException("Falsche Eingabe!");}
		System.out.println("Strafe(1-5):"); 		int strafe = sc.nextInt(); 		if (strafe > 5 || strafe < 1) {throw new InputMismatchException("Falsche Eingabe!");}
		System.out.println("Aufwand(1-n):"); 		int aufwand = sc.nextInt(); 	if (aufwand < 0) {throw new InputMismatchException("Falsche Eingabe!");}
		System.out.println("Risiko(1-5):"); 		int risk = sc.nextInt(); 		if (risk > 5 || risk < 1) {throw new InputMismatchException("Falsche Eingabe!");}
		System.out.println("Projekt:"); 			String project = sc.next();
		double prio = (double) (mehrwert + strafe) /(aufwand+risk);
		UserStory userStory = new UserStory(id, titel, akzeptanzkriterium, mehrwert, strafe, aufwand, risk, prio);
		userStory.setProject(project);
		addUserStory((T) userStory);
	}
	public static void main (String[] args) throws Exception {
		Container con = Container.getInstance();
		PersistenceStrategy<UserStory> strategy = new PersistenceStrategyStreamNeu<>();
		((PersistenceStrategyStreamNeu<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/test/testdata.ver");
		con.strategy = strategy;
		con.startEingabe();
	}
}
