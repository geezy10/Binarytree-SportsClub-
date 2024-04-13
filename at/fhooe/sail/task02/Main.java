package at.fhooe.sail.task02;

public class Main {
    public static void main(String[] args) {
        Section Football = new Section("Football");
        Football.addMember(new AmateurAthlete("Alice", 2));
        Football.addMember(new Trainer("Bob", 5));
        Football.addMember(new TopAthlete("Charlie", 3));

        Section Tennis = new Section("Tennis");
        Tennis.addMember(new AmateurAthlete("Felix", 4));
        Tennis.addMember(new Trainer("Greta", 2));
        Tennis.addMember(new TopAthlete("Hans", 5));
        AbstractMember schusi = new AmateurAthlete("Schusi", 1);
        Tennis.addMember(schusi);
        System.out.println(Tennis.isMember(schusi));
        Tennis.removeMember(schusi);
        System.out.println(Tennis.isMember(schusi));
        Section Sportverein = new Section("Sportverein");

        Sportverein.addMember(Football);
        Sportverein.addMember(Tennis);
        Sportverein.addMember(new HonoraryMember("Irene"));
        Sportverein.addMember(new HonoraryMember("Johann"));



        System.out.println(Sportverein.toString(true));
     //   System.out.println(Sportverein.toString(false));
        System.out.println(Sportverein.toString());

























    }
}
