package com.company.designpattern.prototype.deep;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Setter
@Getter
public class DeepCloneableTarget implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass){
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
