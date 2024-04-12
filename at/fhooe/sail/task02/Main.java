package at.fhooe.sail.task02;

public class Main {
    public static void main(String[] args) {
        Section Football = new Section("Football");
        Football.addMember(new AmateurAthlete("Alice", 2));
        Football.addMember(new Trainer("Bob", 5));
        Football.addMember(new TopAthlete("Charlie", 3));

        AbstractMember member2 = new ChairMember("Felix", 10.0);
        Football.addMember(member2);

        Section Tennis = new Section("Tennis");
        AbstractMember member1 = new TopAthlete("Axel", 5);
        Tennis.addMember(member1);
        Football.addMember(Tennis);
        System.out.println(Football.toString(true));
        System.out.println(Tennis.toString(false));

    }
}

