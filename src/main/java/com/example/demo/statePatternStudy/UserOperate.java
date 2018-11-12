package com.example.demo.statePatternStudy;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 员工操作类
 */
public abstract class UserOperate {
    //判断记录是否与其他记录冲突
    //该条记录是否已经存在
    // 该操作的执行状态
    //该操作是否需要更新用户的状态

     User user;
     UserLog userLog;

    //日期是否需要立即执行
    abstract Boolean dateIsOver();
    // 记录是否已经存在
    abstract Boolean recordHasExist();

    public abstract Boolean recordValid();


    public  void updateUserAndLog(){
        recordValid();
        System.out.println("userName " + user.getName());
        System.out.println("userLogName " + userLog.getId());


    };

    public UserOperate(User user, UserLog userLog) {
        this.user = user;
        this.userLog = userLog;
    }
}
