package edu.mum.cs.cs525.labs.skeleton.design.pattern.decorator;

import edu.mum.cs.cs525.labs.skeleton.design.pattern.stretegy.InterestStrategy;

public class P2PromotionDecorator extends InterestPromoteDecorator {

    public P2PromotionDecorator(InterestStrategy decoratedStrategy) {
        super(decoratedStrategy);
    }

    public double getBalanceWithInterest(double balance) {
        return super.getBalanceWithInterest(balance) + balance * 0.02;
    }

}
