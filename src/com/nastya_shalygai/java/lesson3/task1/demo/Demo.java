package com.nastya_shalygai.java.lesson3.task1.demo;

import com.nastya_shalygai.java.lesson3.task1.student.Student;
import com.nastya_shalygai.java.lesson3.task1.study.Courses;
import com.nastya_shalygai.java.lesson3.task1.study.IndividualProgram;

public class Demo {

    public static void main(String[] args) {

        IndividualProgram program1 = new IndividualProgram("Java Developer", IndividualProgram.convertStringToDate("20.01.2017"));
        program1.setProgram(Courses.COURSE1, Courses.COURSE4, Courses.COURSE2);

        IndividualProgram program2 = new IndividualProgram("J2EE Developer", IndividualProgram.convertStringToDate("10.02.2017"));
        program2.setProgram(Courses.COURSE3, Courses.COURSE5);

        Student student1 = new Student("Ivanov Ivan", program1);
        student1.printReport(1);

        Student student2 = new Student("Petrov Petr", program2);
        student2.printReport(0);
    }
}
