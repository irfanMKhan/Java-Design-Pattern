package edu.mum.cs.cs525.labs.skeleton.stretegy;

public class CheckingInterestStrategy implements InterestStrategy {

    public double getBalanceWithInterest(double balance) {
        if (balance < 1000)
            balance = balance + balance * 0.015;
        else balance = balance + balance * 0.025;
        return balance;
    }

}
