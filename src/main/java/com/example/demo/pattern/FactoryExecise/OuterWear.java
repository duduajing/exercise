package com.example.demo.pattern.FactoryExecise;

import lombok.Getter;
import lombok.Setter;

/***
 *
 * 外套
 * @author dcj
 * @date 2018/11/26 4:59 PM
 * @param
 * @return
 */
@Setter
@Getter
public class OuterWear extends Clothes{

    @Override
    public String getName(){
        return "外套";
    }

    @Override
    public String getMaterial(){
        return "纤维";
    }


}
