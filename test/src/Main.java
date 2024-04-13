import at.fhooe.sail.task02.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {
    private Section section;

    @BeforeEach
    void setup() {
        section = new Section("Test section");
        AmateurAthlete member = new AmateurAthlete("Alice", 2);
        assertTrue(section.addMember(member));
        TopAthlete member2 = new TopAthlete("Felix", 5);
        assertTrue(section.addMember(member2));
    }

    @Test
    void testAddMember() {
        AmateurAthlete member = new AmateurAthlete("Max", 2);
        assertTrue(section.addMember(member));
        TopAthlete member2 = new TopAthlete("Hansi", 5);
        assertTrue(section.addMember(member2));
    }

    @Test
    void testAddMemberexisting() {
        AmateurAthlete member2 = new AmateurAthlete("Alice", 2);
        assertFalse(section.addMember(member2));
    }

    @Test
    void removeMember() {
        AmateurAthlete member = new AmateurAthlete("Max", 2);
        assertTrue(section.addMember(member));
        assertTrue(section.removeMember(member));
        AmateurAthlete member3 = new AmateurAthlete("Franz", 2);
        assertFalse(section.removeMember(member3));
    }

    @Test
    void isMember() {
        AmateurAthlete member = new AmateurAthlete("Max", 2);
        assertTrue(section.addMember(member));
        assertTrue(section.isMember(member));
        AmateurAthlete member3 = new AmateurAthlete("Franz", 2);
        assertFalse(section.isMember(member3));
    }

    @Test
    void getIncomeandCosts() {
        section.getCosts();
        section.getIncome();
        section.getSurplus();
        assertEquals(420, section.getIncome());
        assertEquals(360, section.getCosts());
        assertEquals(60, section.getSurplus());
    }

    //amateurathlete
    @Test
    void incomeAmateurAthlete() {
        AmateurAthlete athlete = new AmateurAthlete("Alice", 2);
        assertEquals(25 * 12, athlete.getIncome());
    }

    @Test
    void costsAmateurAthlete() {
        AmateurAthlete athlete = new AmateurAthlete("Alice", 2);
        assertEquals(2 * 2.5 * 12, athlete.getCosts());
    }

    @Test
    void costsZero() {
        AmateurAthlete athlete = new AmateurAthlete("Alice", 0);
        assertEquals(0, athlete.getCosts());
    }

    //trainer
    @Test
    void incomeTrainer() {
        Trainer trainer = new Trainer("Bob", 4);
        assertEquals(10 * 12, trainer.getIncome());
    }

    @Test
    void costsTrainer() {
        Trainer trainer = new Trainer("Bob", 4);
        assertEquals(4 * 40 * 12, trainer.getCosts());
    }

    @Test
    void costsIsZero() {
        Trainer trainer = new Trainer("Bob", 0);
        assertEquals(0, trainer.getCosts());
    }
    @Test
    void incomeChairMember() {
        ChairMember chairMember = new ChairMember("Alice", 2);
        assertEquals(2 * 100, chairMember.getIncome());
    }

    @Test
    void costsChairMember() {
        ChairMember chairMember = new ChairMember("Alice", 2);
        assertEquals(2 * 100 * 0.2, chairMember.getCosts());
    }

    @Test
    void costssZero() {
        ChairMember chairMember = new ChairMember("Alice", 0);
        assertEquals(0, chairMember.getCosts());
    }
    @Test
    void incomeHonoraryMember() {
        HonoraryMember honoraryMember = new HonoraryMember("Alice");
        assertEquals(0, honoraryMember.getIncome());
    }

    @Test
    void costsHonoraryMember() {
        HonoraryMember honoraryMember = new HonoraryMember("Alice");
        assertEquals(20, honoraryMember.getCosts());
    }

    @Test
    void incomeSupportingMember() {
        SupportingMember supportingMember = new SupportingMember();
        assertEquals(100, supportingMember.getIncome());
    }

    @Test
    void costsSupportingMember() {
        SupportingMember supportingMember = new SupportingMember();
        assertEquals(15, supportingMember.getCosts());
    }
}

