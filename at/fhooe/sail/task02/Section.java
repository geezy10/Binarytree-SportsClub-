package at.fhooe.sail.task02;

import at.fhooe.sail.task01.BinarySearchTree;

public class Section extends AbstractMember {

    public Section(String name) {
		super(name);
	}
	BinarySearchTree<AbstractMember> tree = new BinarySearchTree<>();

    boolean addMember(AbstractMember m){
    	if (tree.find(m))
    		return false; 
    	tree.insert(m); 
    	return true; 

    }
    boolean removeMember(AbstractMember m){
    	return tree.remove(m);


    }
    boolean isMember(AbstractMember m){
    	return tree.find(m);

    }
	@Override
	public double getIncome() {
		Comparable<AbstractMember>[] abstractMembers = tree.toArray(true);
		double sum = 0;
		for (int i = 0; i<abstractMembers.length; i++) {
			sum = sum + ((AbstractMember) abstractMembers[i]).getIncome();
		} return sum;
	}
	@Override
	public double getCosts() {
		Comparable<AbstractMember>[] abstractMembers = tree.toArray(true);
		double sum=0;
		for (int i = 0; i<abstractMembers.length; i++) {
			sum = sum + ((AbstractMember) abstractMembers[i]).getCosts();
		} return sum;

	}
	@Override
	public String toString (boolean ascending){
		Comparable<AbstractMember>[] abstractMembers = tree.toArray(true);
		StringBuilder builder = new StringBuilder();

		builder.append(name).append(":   Einnahmen:    ").append(getIncome());
		builder.append("     Kosten: ").append(getCosts()).append("€    ");
		builder.append("     Überschuss: ").append(getSurplus());
		builder.append("\n");
		//counter einrücken
		for (int i = 0; i<abstractMembers.length; i++) {
			builder.append(((AbstractMember) abstractMembers[i]).toString(ascending)).append("\n");
			//counter wieder zurück
		} return builder.toString();
	}
	
	}

