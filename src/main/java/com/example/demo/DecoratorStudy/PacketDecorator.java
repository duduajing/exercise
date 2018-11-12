package com.example.demo.DecoratorStudy;

/**
 * PacketDecorator维护核心组件component对象，它负责告知其子类，
 * 其核心业务逻辑该全权委托compent完成，自己仅仅是做增强处理
 */
public abstract class PacketDecorator implements IPacketCreator{

    IPacketCreator component;

    public PacketDecorator(IPacketCreator c){
        component = c;
    }


}
