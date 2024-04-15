package at.fhooe.sail.task02;

public abstract class ActiveMember extends AbstractMember {

    public ActiveMember (String name, int activity){
        super(name);
        this.activity=activity;
    }
    public abstract double getIncome(); 

    public abstract double getCosts(); 

    public int activity;


}

