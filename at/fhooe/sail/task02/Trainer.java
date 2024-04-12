package at.fhooe.sail.task02;

public class Trainer extends ActiveMember {

	public Trainer(String name, int activity) {
		super(name, activity);
	}

	public double getIncome() {
		return 10*12;
	}

	public double getCosts() {
		return activity * 40*12;
	}
}
