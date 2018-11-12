package com.example.demo.statePatternStudy;

public class StateTest {
    public static void main(String[] args) {
//        Context context = new Context();
//        context.setState(context.new Rain());
//        System.out.println(context.stateMessage());
//
//        context.setState(context.new Sunshine());
//        System.out.println(context.stateMessage());
        User u = new User();
        u.setName("d");
        UserLog ul = new UserLog();
        ul.setId(2);
        UserOperate uo = new GuardOperate(u, ul);
        uo.updateUserAndLog();
    }
}
