package at.fhooe.sail.task02;

public class HonoraryMember extends AbstractMember {

	public HonoraryMember(String name) {
		super(name);
	}

	@Override
	public double getIncome() {
		return 0;
	}

	public double getCosts() {
		return 20;
	}
}
