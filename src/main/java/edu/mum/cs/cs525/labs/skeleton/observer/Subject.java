package edu.mum.cs.cs525.labs.skeleton.observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void updateObserver(String purpose, double amount);
}
