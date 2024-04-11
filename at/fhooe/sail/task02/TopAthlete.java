package at.fhooe.sail.task02;

public class TopAthlete extends ActiveMember {

	int activity;

	public double getIncome() {
		return 10;
	}

	public double getCosts() {
		return activity * 5;
	}

	public double getSurplus() {
		return getIncome() - getCosts();
	}
}
