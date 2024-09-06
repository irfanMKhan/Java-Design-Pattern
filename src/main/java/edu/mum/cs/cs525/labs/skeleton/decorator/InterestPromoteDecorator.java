package edu.mum.cs.cs525.labs.skeleton.decorator;

import edu.mum.cs.cs525.labs.skeleton.stretegy.InterestStrategy;

public abstract class InterestPromoteDecorator implements InterestStrategy {

    protected InterestStrategy decoratedStrategy;

    public InterestPromoteDecorator(InterestStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    public double getBalanceWithInterest(double balance) {
        return decoratedStrategy.getBalanceWithInterest(balance);
    }

}
