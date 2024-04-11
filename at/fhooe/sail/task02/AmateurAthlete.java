package at.fhooe.sail.task02;

public class AmateurAthlete extends ActiveMember {


	public AmateurAthlete(String name, int activity) {
		super(name,activity);

	}

	public double getIncome() {
		return 25;
	}

	public double getCosts() {
		return activity * 2.5;
	}

}
