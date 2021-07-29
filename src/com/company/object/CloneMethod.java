package com.company.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CloneMethod {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(10, "amit");
        Student student1 = (Student)student.clone();

        System.out.println(student.roll+" "+student.name);
        System.out.println(student1.roll+" "+student1.name);
        student1.setName("john");
        student.setName("Linda");
        System.out.println(student.roll+" "+student.name);
        System.out.println(student1.roll+" "+student1.name);
        System.out.println(student1+" "+student);


    }
}

@NoArgsConstructor
class Student implements Cloneable {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
