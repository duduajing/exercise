package com.example.demo.pattern.proxy.jdk;

import com.example.demo.pattern.proxy.staticed.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class JDKProxyTest {

    public static void main(String[] args) throws IOException {
//        Person obj = (Person) new JDK58().getInstance(new XieMu());
//        System.out.println(obj.getClass());
//        obj.findJob();
        Person obj = (Person) new JDKMeipo().getInstance(new XieMu());
        System.out.println(obj.getClass());
        obj.findLover();

        //JDK中，只要是$开头的一般都是自动生成的
/**
 * 字节码重组的原理：
 * 1：拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
 * 2：JDK Proxy类重新生成一个新的类，同时新的类要实现被代理类已经实现的所有的接口
 * 3：动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
 * 4：编译新生成的java代码.class
 * 5: 再重新加载到JVM中运行
 *
 */
        //通过反编译工具可以查看源代码
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("/Users/dcj/Desktop/$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
