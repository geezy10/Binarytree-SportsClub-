package at.fhooe.sail.task02;

import at.fhooe.sail.task01.BinarySearchTree;

public class Section extends AbstractMember {

    public Section(String name) {
        super(name);
    }

    BinarySearchTree<AbstractMember> tree = new BinarySearchTree<>();

    boolean addMember(AbstractMember m) {
        if (tree.find(m))
            return false;
        tree.insert(m);
        return true;

    }

    boolean removeMember(AbstractMember m) {
        return tree.remove(m);


    }

    boolean isMember(AbstractMember m) {
        return tree.find(m);

    }

    @Override
    public double getIncome() {
        Comparable<AbstractMember>[] abstractMembers = tree.toArray(true);
        double sum = 0;
        for (int i = 0; i < abstractMembers.length; i++) {
            sum = sum + ((AbstractMember) abstractMembers[i]).getIncome();
        }
        return sum;
    }

    @Override
    public double getCosts() {
        Comparable<AbstractMember>[] abstractMembers = tree.toArray(true);
        double sum = 0;
        for (int i = 0; i < abstractMembers.length; i++) {
            sum = sum + ((AbstractMember) abstractMembers[i]).getCosts();
        }
        return sum;

    }

    private static int indentLevel = 0;

    @Override
    public String toString(boolean ascending) {
        Comparable<AbstractMember>[] abstractMembers = tree.toArray(ascending);

        StringBuilder builder = new StringBuilder();


        builder.append(name).append(":   Einnahmen:    ").append(getIncome());
        builder.append("     Kosten: ").append(getCosts()).append("€    ");
        builder.append("     Überschuss: ").append(getSurplus());
        builder.append("\n");


        for (int i = 0; i < abstractMembers.length; i++) {
            StringBuilder indentBuilder = new StringBuilder();
            for (int j = 0; j < indentLevel; j++) {
                indentBuilder.append("\t");
            }
            indentLevel++;
            builder.append(indentBuilder).append("\t").append(((AbstractMember) abstractMembers[i])
                    .toString(ascending)).append("\n");
            indentLevel--;
        }
        return builder.toString();
    }

}

