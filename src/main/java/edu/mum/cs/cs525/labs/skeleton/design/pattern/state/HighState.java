package edu.mum.cs.cs525.labs.skeleton.design.pattern.state;

public class HighState implements FanState {
    @Override
    public void pullGreen(CeilingFan fan) {
        System.out.println("turning off");
        fan.setState(new OffState());
    }

    @Override
    public void pullRed(CeilingFan fan) {
        System.out.println("medium speed");
        fan.setState(new MediumState());
    }
}