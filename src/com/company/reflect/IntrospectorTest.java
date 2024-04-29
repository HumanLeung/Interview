package com.company.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author Administrator
 */
public class IntrospectorTest {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd: pds){
                System.out.println("属性：" + pd.getName());
            }
        } catch (IntrospectionException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
