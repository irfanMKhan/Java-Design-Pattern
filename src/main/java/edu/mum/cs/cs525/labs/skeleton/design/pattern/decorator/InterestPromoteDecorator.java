package edu.mum.cs.cs525.labs.skeleton.design.pattern.decorator;

import edu.mum.cs.cs525.labs.skeleton.design.pattern.stretegy.InterestStrategy;

public abstract class InterestPromoteDecorator implements InterestStrategy {

    protected InterestStrategy decoratedStrategy;

    public InterestPromoteDecorator(InterestStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    public double getBalanceWithInterest(double balance) {
        return decoratedStrategy.getBalanceWithInterest(balance);
    }

}
