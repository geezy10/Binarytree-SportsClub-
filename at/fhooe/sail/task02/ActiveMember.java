package at.fhooe.sail.task02;

public abstract class ActiveMember extends AbstractMember {

    public ActiveMember (String name, int activity){
        super(name);
        this.activity=activity;
    }
    public abstract double getIncome(); //calculates the income of the member

    public abstract double getCosts(); // calculates the costs of the member

    public int activity;


}

