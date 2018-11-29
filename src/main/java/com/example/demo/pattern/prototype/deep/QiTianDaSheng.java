package com.example.demo.pattern.prototype.deep;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Date;

@Setter
@Getter
public class QiTianDaSheng extends Monkey implements Serializable, Cloneable{

    private Jingubang jingubang;

    public QiTianDaSheng() {
        //初始化数据
        this.birthday = new Date();
        this.jingubang = new Jingubang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream  bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            QiTianDaSheng copy = (QiTianDaSheng) ois.readObject();
            copy.birthday = new Date();
            return copy;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public QiTianDaSheng copy(QiTianDaSheng target){

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.setHeight(target.getHeight());
        qiTianDaSheng.setWeight(target.getWeight());

        qiTianDaSheng.jingubang = new Jingubang();
        qiTianDaSheng.jingubang.setH(target.jingubang.getH());
        qiTianDaSheng.jingubang.setR(target.jingubang.getR());
        qiTianDaSheng.birthday = new Date();

        return qiTianDaSheng;

    }
}
