package edu.mum.cs.cs525.labs.skeleton.design.pattern.proxy;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        ComplexClassProxy proxy = new ComplexClassProxy();
        ComplexInterface complex = proxy.getProxy();


        System.out.println("Before calling veryComplicatedTask...");
        complex.veryComplicatedTask();
        System.out.println("After calling veryComplicatedTask...");
    }
}
