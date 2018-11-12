package com.example.demo.statePatternStudy;

import java.util.Date;

public class GuardOperate extends UserOperate{



    /**
     * true 生效日期小于今天 false 生效日期大于等于今天
     * @return
     */
    @Override
    Boolean dateIsOver() {
        Date effectDate = userLog.getEffectDate();
        return effectDate.before(new Date());
    }

    @Override
    Boolean recordHasExist() {
        if(this.dateIsOver()){
            // 查询是否是最新一条转岗记录
            if(true){
                user.setUserType(userLog.getPositionType());
                user.setCollegeId(userLog.getCollegeId());
                user.setFamilyId(userLog.getFamilyId());
                user.setFamilyType(userLog.getFamilyType());
                user.setGroupId(userLog.getGroupId());
                Integer userTypeId =  userLog.getGroupId()==null?userLog.getFamilyId():userLog.getCollegeId();
                user.setUserTypeId(userTypeId);

                userLog.setExecuteFlag(1);
            }else{
                userLog.setExecuteFlag(1);
            }
        }else{
            //查询是否有未执行的转岗记录
            if(true){
                return true;
            }else{
                userLog.setExecuteFlag(1);
            }
        }
        return false;
    }

    @Override
    public Boolean recordValid() {
        user.setName("jing");

        return null;
    }

    public GuardOperate(User user, UserLog userLog) {

        super(user,userLog);
    }


}
