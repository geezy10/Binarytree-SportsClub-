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

        Section Sportverein = new Section("Sportverein");

        Sportverein.addMember(Football);
        Sportverein.addMember(Tennis);
        Sportverein.addMember(new HonoraryMember("Irene"));
        Sportverein.addMember(new HonoraryMember("Johann"));



        System.out.println(Sportverein.toString(true));























//        Section Tennis = new Section("Tennis");
//        AbstractMember member1 = new TopAthlete("Axel", 5);
//        Tennis.addMember(member1);
//        //Football.addMember(Tennis);
//        Section Swimming = new Section("Swimming");
//        System.out.println(Football.toString(true));
//        System.out.println(Tennis.toString(false));

    }
}

