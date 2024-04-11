package at.fhooe.sail.task02;

public class ChairMember extends AbstractMember {

	double comp;

	public ChairMember(double comp, String name) {
		super(name);
		this.comp = comp;
	}

	public double getIncome() {
		return comp * 100;
	}

	public double getCosts() {
		return getIncome() * 0.2;
	}

	public double getSurplus() {
		return getIncome() - getCosts();
	}
}
