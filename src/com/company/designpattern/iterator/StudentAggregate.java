package com.company.designpattern.iterator;

/**
 * @author Administrator
 */
public interface StudentAggregate {
    void addStudent(Student stu);

    void removeStudent(Student stu);

    StudentIterator getStudentIterator();
}
