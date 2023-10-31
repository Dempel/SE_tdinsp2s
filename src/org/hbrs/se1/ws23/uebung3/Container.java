package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Container{

	/*
	 * Interne ArrayList zur Abspeicherung der Objekte
	 * Alternative: HashMap oder Set. HashMap hat vor allem Probleme 
	 * bei der Bewahrung der Konsistenz vom Key und Value (siehe TestStore, letzter Test)
	 */
	private List<Member> liste = new ArrayList<Member>();
	private static Container container;
	public PersistenceStrategy<Member> strategy;


	private Container() {
		liste = new ArrayList<>();
	}
	public static Container createContainer() {
		if (container == null) {
			container = new Container();
		}
		return container;
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
		liste = (ArrayList<Member>)strategy.load();

	}
	public List<Member> getCurrentList() {
		return liste;

	}
	public void deleteAll() {
		while (size() > 0) {
			liste.remove(0);
		}
	}

	/*
	 * Methode zum Hinzufuegen einer Member.
	 * @throws ContainerException
	 */ 
	public void addMember ( Member r ) throws ContainerException {

		if (r == null) {
			ContainerException ex = new ContainerException();
			throw ex;
		}

		if ( contains( r ) == true ) {
			ContainerException ex = new ContainerException(  r.getID().toString() );
			throw ex;
		}
		liste.add( r );
	
	} 
	
	/*
	 * Methode zur Ueberpruefung, ob ein Member-Objekt in der Liste enthalten ist
	 * 
	 */
	private boolean contains(Member r) {
		Integer ID = r.getID();
		for ( Member rec : liste) {
			// wichtig: Check auf die Values innerhalb der Integer-Objekte!
			if ( rec.getID().intValue() == ID.intValue() ) {
				return true;
			}
		}
		return false;
		
		// liste.contains(r), falls equals-Methode in Member ueberschrieben.
	}
	/*
	 * Methode zum Loeschen einer Member
	 * In Praxis durchaus verwendet: C-Programme; beim HTTP-Protokoll; SAP-Anwendung (R3); Mond-Landung ;-)
	 * 
	 */
	public String deleteMember( Integer id ) {
		Member rec = getMember( id );
		if (rec == null) return "Member nicht enthalten - ERROR"; else {
			liste.remove(rec);
			return "Member mit der ID " + id + " konnte geloescht werden";
		}
	}
	
	/*
	 * Methode zur Bestimmung der Anzahl der von Member-Objekten
	 * Aufruf der Methode size() aus List
	 */
	public int size(){
		return liste.size();
	}


	//Interne Methode zur Ermittlung einer Member

	private Member getMember(Integer id) {
		for ( Member rec : liste) {
			if (id == rec.getID().intValue() ){
				return rec;
			}
		}
		return null;
	}

}
