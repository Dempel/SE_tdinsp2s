package org.hbrs.se1.ws23.uebung3;

import java.util.List;

public class Client {

    public static void main(String[] args) throws ContainerException {
        Container container = Container.createContainer();
        Member member1 = (Member) new MemberKonkret(1);
        Member member2 = (Member) new MemberKonkret(2);
        container.addMember(member1);
        container.addMember(member2);
        List<Member> liste1 = container.getCurrentList();
        System.out.println(liste1);
        MemberView.dump(liste1);


    }

}
