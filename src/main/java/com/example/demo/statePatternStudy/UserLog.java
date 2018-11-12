package com.example.demo.statePatternStudy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class UserLog {
    private Integer id;
    private Integer collegeId;
    private Integer userId;
    private Integer familyId;
    private Integer groupId;
    private Integer familyType;
    private Integer type;
    private String positionType;
    private Integer executeFlag;
    private Date effectDate;
    private Date endDate;
    private Integer canceled;
}
