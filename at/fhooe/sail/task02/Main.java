package at.fhooe.sail.task02;

public class Main {
    public static void main(String[] args) {
        Section Football = new Section("Football");
        Football.addMember(new AmateurAthlete("Alice", 2));


        // Create instances of concrete subclasses of AbstractMember

        AbstractMember member2 = new ChairMember("Felix", 10.0);
        Football.addMember(member2);
        Section Damen = new Section("Damen");
        AbstractMember member1 = new TopAthlete("Axel", 5);
        Damen.addMember(member1);
        Football.addMember(Damen);
        System.out.println(Football.toString(true));


    }
}

