package edu.mum.cs.cs525.labs.skeleton.design.pattern.state;

public class LowState implements FanState {
    @Override
    public void pullgreen(CeilingFan fan) {
        System.out.println("medium speed");
        fan.setState(new MediumState());
    }

    @Override
    public void pullred(CeilingFan fan) {
        System.out.println("turning off");
        fan.setState(new OffState());
    }
}
