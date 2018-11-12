package com.example.demo.DecoratorStudy;
/**
 * 具体的装饰器，它负责对数据包进行头部的处理。
 * 需要特别注意的是，它委托了具体组件component进行核心
 * 业务处理。
 */
public class PacketHTTPHeaderCreator extends PacketDecorator{
    public PacketHTTPHeaderCreator(IPacketCreator c) {
        super(c);
    }

    @Override
    public String handleContent(){
        StringBuffer sb = new StringBuffer();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon:31DEc201204:25:57GMT\n");
        sb.append(component.handleContent());
        return sb.toString();
    }
}
