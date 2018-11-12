package com.example.demo.DecoratorStudy;

/**
 * ContreteComponent 具体组件
 */
public class PacketBodyCreator implements IPacketCreator{

    @Override
    public String handleContent() {
        return "Content of Packet";
    }
}
