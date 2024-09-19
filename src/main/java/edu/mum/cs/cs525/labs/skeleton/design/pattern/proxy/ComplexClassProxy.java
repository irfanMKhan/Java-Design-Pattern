package edu.mum.cs.cs525.labs.skeleton.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ComplexClassProxy {

    private final ComplexInterface proxyInstance;

    public ComplexClassProxy() {
        this.proxyInstance = (ComplexInterface) Proxy.newProxyInstance(
                ComplexInterface.class.getClassLoader(),
                new Class[]{ComplexInterface.class},
                new ComplexClassInvocationHandler());
    }

    public static void main(String[] args) throws InterruptedException {
        ComplexClassProxy proxy = new ComplexClassProxy();
        ComplexInterface complex = proxy.getProxy();


        System.out.println("Before calling veryComplicatedTask...");
        complex.veryComplicatedTask();
        System.out.println("After calling veryComplicatedTask...");
    }

    public ComplexInterface getProxy() {
        return this.proxyInstance;
    }

    private class ComplexClassInvocationHandler implements InvocationHandler {

        private ComplexClass realSubject;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (realSubject == null) {
                System.out.println("Initializing the real subject (ComplexClass)...");
                realSubject = new ComplexClass();
            }
            return method.invoke(realSubject, args);
        }
    }
}