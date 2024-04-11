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
	public double getSurplus() {
		Comparable<AbstractMember>[] abstractMembers = tree.toArray(true);
		double sum=0;
		for (int i = 0; i<abstractMembers.length; i++) {
			sum = sum + ((AbstractMember) abstractMembers[i]).getSurplus();
		} return sum;
	}
	
	}

