package com.example.demo.statePatternStudy;

public class Context {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String stateMessage(){
        return state.getState();
    }

    class Sunshine implements State{

        @Override
        public String getState() {
            return "晴天";
        }
    }

    class Rain implements State{

        @Override
        public String getState() {
            return "下雨";
        }
    }
}
