package at.fhooe.sail.task02;

public class Main {
	public static void main(String[] args) {
        // Create instances of concrete subclasses of AbstractMember
        AbstractMember member1 = new ChairMember(500.0, "Alice");
        AbstractMember member2 = new ChairMember(700.0, "Bob");


      
        
    
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

