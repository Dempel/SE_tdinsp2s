package org.hbrs.se1.ws23.uebung3.test;
import org.hbrs.se1.ws23.uebung3.Container;
import org.hbrs.se1.ws23.uebung3.ContainerException;
import org.hbrs.se1.ws23.uebung3.Member;
import org.hbrs.se1.ws23.uebung3.MemberKonkret;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest2 {
    Container c = Container.createContainer();

    @BeforeEach
    void leereContainer() {
        c.strategy = null;
        c.deleteAll();
    }

    @Test
    void testNoStrategy() throws ContainerException {
        Member member1 = new MemberKonkret(1);
        c.addMember(member1);
        assertNull(c.strategy);
        assertThrows(PersistenceException.class, () -> c.store());
        try {
            c.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, e.getExceptionTypeType());
        }
    }
    @Test
    void testePersistenceStrategyMongoDB() throws ContainerException {
        Member member1 = new MemberKonkret(1);
        c.addMember(member1);
        c.strategy = new PersistenceStrategyMongoDB<Member>();
        assertThrows(UnsupportedOperationException.class, () -> c.store());
        assertThrows(UnsupportedOperationException.class, () -> c.load());
    }
    @Test
    void testeDirectories() {
        PersistenceStrategyStream strategy = new PersistenceStrategyStream<Member>();
        strategy.setLocation("/");
        c.strategy = strategy;
        try {
            c.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getExceptionTypeType());
        }
    }

    @Test
    void roundTripTest() throws ContainerException, PersistenceException {
        PersistenceStrategyStream strategyStream = new PersistenceStrategyStream<Member>();
        strategyStream.setLocation("test/org/hbrs/se1/ws23/uebung3/test");
        c.strategy = strategyStream;
        c.strategy.openConnection();
        Member member1 = new MemberKonkret(1);
        c.addMember(member1);
        List<Member> liste1 = new ArrayList<Member>();
        liste1.add(member1);

        assertEquals(1,c.size());
        assertEquals(liste1,c.getCurrentList());
        c.store();
        c.deleteMember(1);
        assertEquals(0,c.size());
        c.deleteAll();
        c.load();
        assertEquals(1,c.size());

        c.strategy.closeConnection();
    }
}
