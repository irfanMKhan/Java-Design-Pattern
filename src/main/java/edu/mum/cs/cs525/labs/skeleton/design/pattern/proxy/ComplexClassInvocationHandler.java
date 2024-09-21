package edu.mum.cs.cs525.labs.skeleton.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ComplexClassInvocationHandler implements InvocationHandler {

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
