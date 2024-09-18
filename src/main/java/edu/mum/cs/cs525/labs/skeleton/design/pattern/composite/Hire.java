package edu.mum.cs.cs525.labs.skeleton.design.pattern.composite;

import java.util.function.Consumer;

public abstract class Hire {

    private String name;

    private String email;

    private Double salary;

    public Hire(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public abstract Double getBudget();

    public abstract void process(Consumer<Hire> action);

}
