package edu.mum.cs.cs525.labs.skeleton.design.pattern.composite;

import java.util.function.Consumer;

public class Employee extends Hire {

    public Employee(String name, String email, double salary) {
        super(name, email, salary);
    }

    @Override
    public Double getBudget() {
        return getSalary();
    }

    @Override
    public void process(Consumer<Hire> action) {
        action.accept(this);
    }

}
