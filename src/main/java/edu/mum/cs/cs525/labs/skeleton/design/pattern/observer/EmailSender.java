package edu.mum.cs.cs525.labs.skeleton.design.pattern.observer;

public class EmailSender implements Observer {

    public void update(String purpose, double amount) {
        System.out.println("Sending email for the purpose of : " + purpose + "; amount : " + amount);
    }

}
