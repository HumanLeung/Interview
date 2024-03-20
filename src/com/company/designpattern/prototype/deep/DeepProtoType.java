package com.company.designpattern.prototype.deep;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * @author Administrator
 */
@Setter
@Getter
public class DeepProtoType implements Serializable,Cloneable {
    public String name;
    public DeepCloneableTarget deepCloneableTarget;
    public DeepProtoType(){
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        deep = super.clone();
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    /**
     * 深拷贝 - 方式2 通过对象的序列化实现 (推荐)
     * @return
     */
    public Object deepClone() {

        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
                ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bis)){

            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
