package at.fhooe.sail.task02;

public class ChairMember extends AbstractMember {

	public double comp;

	public ChairMember(String name, double comp) {
		super(name);
		this.comp = comp;
	}

	public double getIncome() {
		return comp * 100;
	}

	public double getCosts() {
		return getIncome() * 0.2;
	}


}
