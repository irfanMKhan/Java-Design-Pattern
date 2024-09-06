package edu.mum.cs.cs525.labs.skeleton.observer;

public class Logger implements Observer {

    public void update(String purpose, double amount) {
        System.out.println("Logging for the purpose of : " + purpose + "; amount : " + amount);
    }

}
