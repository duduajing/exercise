package com.example.demo.statePatternStudy;


public class Actor {
    public void act(){

    }
}

class HappyActor extends Actor{
    @Override
    public  void act(){
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor{
    @Override
    public void act(){

    }
}
// 相当于状态模式中的context
class Stage{
    private Actor actor = new HappyActor();
    //改变引用actor的指向的具体类型
    public void change(){
        actor = new SadActor();
    }
    //根据状态的不同执行不同的行为
    public void performPlay(){
        actor.act();
    }
}