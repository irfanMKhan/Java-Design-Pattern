package edu.mum.cs.cs525.labs.skeleton.design.pattern.stretegy;

public class SavingInterestStrategy implements InterestStrategy{
    public double getBalanceWithInterest(double balance) {
        if (balance < 1000)
            balance = balance + balance * 0.01;
        else if (balance < 5000) {
            balance = balance + balance * 0.02;
        } else balance = balance + balance * 0.04;
        return balance;
    }
}
