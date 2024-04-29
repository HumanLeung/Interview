package com.company.reflect;

import com.company.designpattern.proxy.staticproxy.RentHouse;
import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException {


        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType() instanceof ParameterizedType){
                ParameterizedType genericType = (ParameterizedType) field.getGenericType();
                Type[] arguments = genericType.getActualTypeArguments();
                for (Type type : arguments) {
                    System.out.println(type);
                }
            }
        }

        Class<?> clazz = Student.class;
        Type superType = clazz.getGenericSuperclass();
        if (superType instanceof ParameterizedType){
            ParameterizedType superclass = (ParameterizedType) clazz.getGenericSuperclass();
            System.out.println("genericSuperClass " + superclass);
            System.out.println("ownerType------" + superclass.getOwnerType());
            System.out.println("rawType----" + superclass.getRawType());
            Type[] arguments = superclass.getActualTypeArguments();
            for (Type argument : arguments){
                System.out.println(argument);
            }
        }

        Class<?> superClazz = clazz.getSuperclass();
        System.out.println("this is superClass " + superClazz);

        Type type = Student.class;
        Class<?> clazz2 = type.getClass();
        if (!Modifier.isAbstract(clazz.getModifiers()) && !clazz2.isInterface() && !clazz2.isPrimitive()){
            Type newType = Student.class;
            System.out.println("this is a new type " + newType);
        }

        Method method  = ((Class<?>) type).getMethod("test01", Map.class, List.class);
        Parameter[] parameters = method.getParameters();
        Type[] t = method.getGenericParameterTypes();
        for (Parameter parameter : parameters){
            if (parameter.isAnnotationPresent(Reference.class)){
               Reference reference = parameter.getAnnotation(Reference.class);
                System.out.println(reference);
            }
        }

        for (Type paramType : t) {
            System.out.println("#"+paramType);
            if(paramType instanceof ParameterizedType){
                //获取泛型中的具体信息
                Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    System.out.println("泛型类型："+genericType);
                }
            }
        }

        Class<?> returnType = method.getReturnType();
        Class<?> declaringClass = method.getDeclaringClass();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        System.out.println("returnType---" + returnType);
        System.out.println(declaringClass);
        for (Annotation[] annotations : parameterAnnotations){
            for (Annotation a:annotations){
                System.out.println(a);
            }
        }

        Method m2 = ((Class<?>) type).getMethod("test02",null);
        Type returnType2 = m2.getGenericReturnType();
        System.out.println(returnType2.getTypeName());
        if (returnType2 instanceof ParameterizedType){
             Type[] genericTypes = ((ParameterizedType) returnType2).getActualTypeArguments();
             for (Type genericType : genericTypes){
                 System.out.println("返回值，泛型类型：" + genericType);
             }
        }
    }
}
