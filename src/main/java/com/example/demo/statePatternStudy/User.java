package com.example.demo.statePatternStudy;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class User {

    private Integer id;

    private String entUserId;

    private String name;

    private String mobile;

    private String mail;

    private String openId;

    private Integer roleId;

    private String password;

    private String userType;

    private Integer userTypeId;

    private String changedType;

    private Integer changedTypeId;
    private String showName;
    private String changeShowName;
    private String  showNameIds;
    private Integer wechatDepartmentId;
    private String  wechatDepartmentName;
    private Integer enable;
    private Integer sex;
    private String idCard;
    private Date joinDate;

    /*
    是否有绩效权限: 0 是 1 否
     */
    private Boolean privilege;
    private Boolean privilegeView;
    private Boolean isDelete;
    private Integer collegeId;
    private Integer familyId;
    private Integer groupId;
    private Integer familyType;
    /*
      0 在职 1 休假 2 离职 的状态
     */
    private Integer currentState;

    private String currentStateName;
}
