package edu.mum.cs.cs525.labs.skeleton.design.pattern.proxy;

import java.lang.reflect.Proxy;

public class ComplexClassProxy {

    private final ComplexInterface proxyInstance;

    public ComplexClassProxy() {
        this.proxyInstance = (ComplexInterface) Proxy.newProxyInstance(
                ComplexInterface.class.getClassLoader(),
                new Class[]{ComplexInterface.class},
                new ComplexClassInvocationHandler());
    }


    public ComplexInterface getProxy() {
        return this.proxyInstance;
    }
}