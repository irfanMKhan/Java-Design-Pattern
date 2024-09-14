package edu.mum.cs.cs525.labs.skeleton.design.pattern.observer;

public class SMSSender implements Observer {

    public void update(String purpose, double amount) {
        System.out.println("Sending sms for the purpose of : " + purpose + "; amount : " + amount);
    }

}
