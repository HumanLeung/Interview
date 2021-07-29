package com.company.collections;

public class Student implements Comparable<Student>{
    int rollno;
    String name;
    int age;
    public Student(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }


    @Override
    public int compareTo(Student st) {
//        return Integer.compare(age, st.age);
        return Integer.compare(rollno,st.rollno);
    }
}
