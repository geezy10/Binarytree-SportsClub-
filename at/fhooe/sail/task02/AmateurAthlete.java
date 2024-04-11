package at.fhooe.sail.task02;

public class AmateurAthlete {
	int activity;

	public double getIncome() {
		return 25;
	}

	public double getCosts() {
		return activity * 2.5;
	}
	
	public double getSurplus() {
		return getIncome() - getCosts();
	}
}
