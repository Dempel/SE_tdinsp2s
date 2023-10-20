package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;

public class Container {
    ArrayList<Member> speicher = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        for (Member element : speicher ) {
            if (element.getID() == member.getID()) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        speicher.add(member);
    }
    public String deleteMember(Integer id) {
        for (int i = 0; i < speicher.size(); i++) {
            if (speicher.get(i).getID() == id) {
                speicher.remove(i);
                return "Member erfolgreich entfernt.";
            }
        }
        return "Fehler! Kein Member mit der ID "+ id + " gefunden.";
    }
    public void dump() {
        for (Member element : speicher) {
            System.out.println(element.toString());
        }
    }
    public int size() {
        return speicher.size();
    }
}
