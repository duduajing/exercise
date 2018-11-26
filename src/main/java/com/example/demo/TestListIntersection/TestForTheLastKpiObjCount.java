package com.example.demo.TestListIntersection;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class TestForTheLastKpiObjCount {
    public static void main(String[] args) {
        // 1: 把KpiObjCount 转化成BaseObj
        List<KpiObjCount> kpiObjCountList = new ArrayList<>();
        for(int i=0; i < 10; i++){
            KpiObjCount obj = new KpiObjCount();
            int randomNum = (int)Math.random()*10;
            obj.setId(i);
            obj.setFamilyType(i%2==0?0:1);
            obj.setObjId(i+randomNum);
            obj.setType(i%3==0?"group":"family");
            kpiObjCountList.add(obj);
        }
        List<BaseObj> baseObjs = new ArrayList<>();

        for (KpiObjCount kpiObjCount : kpiObjCountList) {
            BaseObj baseObj = new BaseObj(kpiObjCount.getType(),kpiObjCount.getObjId(), kpiObjCount.getFamilyType());
            baseObjs.add(baseObj);
        }
        // 把对象总数进行分组
        Map<String, List<BaseObj>> baseObjMap =
                baseObjs.stream()
                .collect(Collectors
                        .groupingBy(k->k.getGroupType()+"_"+k.getFamilyType()));
        // 初始化日均学分
        List<MidDetailResult> midDetailResultList = new ArrayList<>();
        for(int i=0; i < 10; i++){
            MidDetailResult obj = new MidDetailResult();
            int randomNum = (int)Math.random()*10;
            obj.setFamilyType(i%2==0?0:1);
            obj.setObjId(i+randomNum);
            obj.setGroupType(i%3==0?"group":"family");
            midDetailResultList.add(obj);
        }
        //日均学分按照分组和家族类型进行分组
        Map<String,List<MidDetailResult>> midDetailResults =  midDetailResultList.stream()
                .collect(Collectors.groupingBy(k->k.getGroupType()+"_"+k.getFamilyType()));

        //初始化管理规模
        List<ManageScale> manageScaleList = new ArrayList<>();
        for(int i=0; i < 10; i++){
            ManageScale obj = new ManageScale();
            int randomNum = (int)Math.random()*10;
            obj.setFamilyType(i%2==0?0:1);
            obj.setObjId(i+randomNum);
            obj.setGroupType(i%3==0?"group":"family");
            manageScaleList.add(obj);
        }
        // 管理规模按照分组类型和家族类型进行分组
        Map<String,List<ManageScale>> manageScaleResults =  manageScaleList.stream()
                .collect(Collectors.groupingBy(k->k.getGroupType()+"_"+k.getFamilyType()));



        //得出所有的分组类型
        Set<String> baseObjKeyList = baseObjMap.keySet();
        Set<String> midDetailResultKeyList = midDetailResults.keySet();
        Set<String> manageScaleKeyList = manageScaleResults.keySet();
        Set<String> theLastKeys = baseObjKeyList.stream()
                .filter(k->(midDetailResultKeyList.contains(k)
                    && manageScaleKeyList.contains(k)))
                .collect(Collectors.toSet());
//        theLastKeys.forEach(System.out::println);
        //对每个分组类型的数据进行数据求交集
        theLastKeys.forEach(k->{
            System.out.println("=========="+k+"==========");
            List<BaseObj> baseObjs1 = baseObjMap.get(k);
            Set<Integer> objKeys = baseObjs1.stream()
                    .collect(Collectors.groupingBy(BaseObj::getObjId))
                    .keySet();
            Set<Integer> objKeys2 = midDetailResults.get(k).stream()
                    .collect(Collectors.groupingBy(BaseObj::getObjId))
                    .keySet();
            Set<Integer> objKeys3 = manageScaleResults.get(k).stream()
                    .collect(Collectors.groupingBy(BaseObj::getObjId))
                    .keySet();
            Set<Integer> theGroupLastKeys = objKeys.stream()
                    .filter(m->(objKeys2.contains(m)
                            && objKeys3.contains(m)))
                    .collect(Collectors.toSet());
            theGroupLastKeys.forEach(System.out::println);
            System.out.println("============对象总数=======");
            baseObjs1.stream()
                    .filter(b->theGroupLastKeys.contains(b.getObjId()))
                    .collect(Collectors.toList()).forEach(System.out::println);
            System.out.println("============日均分=======");
            midDetailResults.get(k).stream()
                    .filter(mid->theGroupLastKeys.contains(mid.getObjId()))
                    .collect(Collectors.toList()).forEach(System.out::println);
        });
    }



}

@Getter
@Setter
@ToString
 class BaseObj{
    protected String groupType;
    protected Integer objId;
    protected Integer familyType;

    public BaseObj() {
    }

    public BaseObj(String groupType, Integer objId, Integer familyType) {
        this.groupType = groupType;
        this.objId = objId;
        this.familyType = familyType;
    }
}
@Getter
@Setter
class KpiObjCount{
    private Integer id;
    private Integer familyType;
    private Integer objId;
    private String type;
    private Date countDate;
}

@Setter
@Getter
@ToString
class MidDetailResult extends BaseObj{
    /**
     * 日均学分
     */
    private double credit;
    /**
     * 组织名称
     */
    private String name;
    /**
     *排名
     */
    private Integer ranking;
    /**
     * 日均学分排名系数
     */
    private Double creditLevel;
    /**
     * 组织名称
     */
    private String organizationName;

    @Override
    public String toString() {
        return "MidDetailResult{" +
                "groupType='" + groupType + '\'' +
                ", objId=" + objId +
                ", familyType=" + familyType +
                ", credit=" + credit +
                ", name='" + name + '\'' +
                ", ranking=" + ranking +
                ", creditLevel=" + creditLevel +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}

/**
 * 管理规模
 */
@Getter
@Setter
class ManageScale extends BaseObj{
    //人数
    private Integer number;
}


/**
 * 在服学员
 */
@Getter
@Setter
class KpiStuCount{

    private Integer familyId;
    private Integer groupId;
    private Integer familyType;
    private Integer countValue;

}

/**
 * 在服学员的变形
 */
@Getter
@Setter
class MidKpiStuCount extends BaseObj{
    private Integer countValue;
}