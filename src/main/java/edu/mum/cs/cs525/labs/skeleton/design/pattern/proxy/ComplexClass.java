package edu.mum.cs.cs525.labs.skeleton.design.pattern.proxy;

public class ComplexClass implements ComplexInterface {

    public ComplexClass() throws InterruptedException {
        super();
        Thread.sleep(10000);
    }

    @Override
    public void veryComplicatedTask() {
        System.out.println("Very complicated task...");
    }
}