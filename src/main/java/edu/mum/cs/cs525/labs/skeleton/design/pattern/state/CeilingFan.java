package edu.mum.cs.cs525.labs.skeleton.design.pattern.state;

public class CeilingFan {
    private FanState currentState;

    public CeilingFan() {
        // Start with the Off state
        currentState = new OffState();
    }

    public void setState(FanState state) {
        this.currentState = state;
    }

    public void pullgreen() {
        currentState.pullgreen(this);
    }

    public void pullred() {
        currentState.pullred(this);
    }
}