package at.fhooe.sail.task02;

public class TopAthlete extends ActiveMember {

	public TopAthlete(String name, int activity) {
		super(name, activity);

	}

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
