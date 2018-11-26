package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ObjectNumber {

    public static void main(String[] args) {
        List<ObjectNumCurrentDate> currDateObjNum = new ArrayList<>();
        for(int i=0; i < 10; i++){
            ObjectNumCurrentDate obj = new ObjectNumCurrentDate();
            int randomNum = (int)Math.random()*10;
            obj.setFamilyId(i+randomNum+(i*randomNum));
            obj.setGroupId(i+randomNum);
            obj.setFamilyType(i%2==0?0:1);
            currDateObjNum.add(obj);
        }

        Map<String,List<ObjectNumCurrentDate>> listMap = currDateObjNum.stream().filter(k->k.getFamilyType().equals(0)).collect(Collectors.groupingBy((ObjectNumCurrentDate obj)->{
                return obj.getGroupId()+"_"+obj.getFamilyType()+"_group";
                })
        );
        Iterator<Map.Entry<String,List<ObjectNumCurrentDate>>> result = listMap.entrySet().iterator();
        while(result.hasNext()){
            Map.Entry<String,List<ObjectNumCurrentDate>> nextMap = result.next();
            System.out.println(nextMap.getKey()+" : "+ nextMap.getValue().toString());
        }

    }


}

@Setter
@Getter
@ToString
class ObjectNumCurrentDate{

    private Integer groupId;
    private Integer familyType;
    private Integer familyId;
}
