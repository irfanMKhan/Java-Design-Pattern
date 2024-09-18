package edu.mum.cs.cs525.labs.skeleton.design.pattern.composite;

import java.util.function.Consumer;

public class SalaryCalculatorConsumer implements Consumer<Hire> {
    private double totalSalary = 0;

    @Override
    public void accept(Hire hire) {
        totalSalary += hire.getSalary(); // Sum the salaries
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}