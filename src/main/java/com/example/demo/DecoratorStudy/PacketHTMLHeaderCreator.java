package com.example.demo.DecoratorStudy;

/**
 * 具体的装饰器，它负责对核心发布的内容进行HTML格式化操作。
 * 需要特别注意的是，它委托了具体组件component进行核心
 * 业务处理。
 */
public class PacketHTMLHeaderCreator extends PacketDecorator{

    public PacketHTMLHeaderCreator(IPacketCreator c) {
        super(c);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(component.handleContent());
        sb.append("</body>");
        sb.append("</html>\n");
        return sb.toString();
    }
}
