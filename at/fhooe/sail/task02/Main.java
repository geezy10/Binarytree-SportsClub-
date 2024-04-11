package at.fhooe.sail.task02;

public class Main {
	public static void main(String[] args) {
        Section Football = new Section("Football");
        Football.addMember(new AmateurAthlete("Alice",2));


        // Create instances of concrete subclasses of AbstractMember
        AbstractMember member1 = new Section("Alice");
        AbstractMember member2 = new Section("Bob");

        TopAthlete topAthlete = new TopAthlete("Charlie", 5);


      
        
    
     // Print information about the members
        System.out.println("Information about members:");
        System.out.println(member1.toString(true)); // Ascending order
        System.out.println(member2.toString(true)); // Ascending order
        System.out.println();

        // Compare two members
        int comparisonResult = member1.compareTo(member2);
        if (comparisonResult < 0) {
            System.out.println(member1.name + " is less than " + member2.name);
        } else if (comparisonResult > 0) {
            System.out.println(member1.name + " is greater than " + member2.name);
        } else {
            System.out.println(member1.name + " is equal to " + member2.name);
        }
    }
}

