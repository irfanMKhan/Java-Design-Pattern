package edu.mum.cs.cs525.labs.skeleton.design.pattern.state;

public class OffState implements FanState {
    @Override
    public void pullgreen(CeilingFan fan) {
        System.out.println("low speed");
        fan.setState(new LowState());
    }

    @Override
    public void pullred(CeilingFan fan) {
        System.out.println("high speed");
        fan.setState(new HighState());
    }
}
