package edu.mum.cs.cs525.labs.skeleton.design.pattern.state;

public class OffState implements FanState {
    @Override
    public void pullGreen(CeilingFan fan) {
        System.out.println("low speed");
        fan.setState(new LowState());
    }

    @Override
    public void pullRed(CeilingFan fan) {
        System.out.println("high speed");
        fan.setState(new HighState());
    }
}
