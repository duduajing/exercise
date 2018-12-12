package com.example.demo.pattern.proxy.staticed;
/**
 *
 *
 * 静态代理类
 * @author dcj
 * @date 2018/12/5 11:39 AM
 * @param
 * @return
 */
public class Father {

    private Person person;
    //没办法扩展
    public Father(Person person) {
        this.person = person;
    }
    //目标对象的引用给拿到
    public void findLover(){
        System.out.println("我可以帮人介绍对象");
        this.person.findLover();
        System.out.println("是否合适");
    }
}
