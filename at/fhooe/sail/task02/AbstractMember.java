package at.fhooe.sail.task02;

public abstract class AbstractMember implements Comparable<AbstractMember>{

	
	public String name; 
	public AbstractMember(String name) {
		this.name = name;
	}
	
    public abstract double  getIncome(); //calculates the income of the member
    public abstract double getCosts(); // calculates the costs of the member
    public abstract double getSurplus(); // calculates the surplus of the member

    
    /* returns a string representation of the member with income, costs and surplus
    in ascending (boolean true) or descending order (boolean false), the default method
    String toString () should give an output in ascending order. */
	
	public String toString(boolean ascending) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(name).append(":   Einnahmen:    ").append(getIncome());
		builder.append("     Kosten: ").append(getCosts()).append("€    "); 
		builder.append("     Überschuss: ").append(getSurplus());
		
		return builder.toString();
	}

    public int compareTo(AbstractMember other) {
        // Compare based on some criteria, for example, names
        return this.name.compareTo(other.name);
    }
}
