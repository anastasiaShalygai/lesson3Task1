package com.nastya_shalygai.java.lesson3.task1.study;

/**
 * Created by Anastasiya on 09.02.2017.
 */
public enum Courses {
    COURSE1("Технология Java Servlets", 16),
    COURSE2("Struts Framework", 24),
    COURSE3("Обзор технологий Java", 8),
    COURSE4("Библиотека JFC/Swing", 16),
    COURSE5("Технология JDBC", 16);

    private String name;
    private int continuance;

    Courses(String name, int continuance) {
        this.name = name;
        this.continuance = continuance;
    }

    public int getContinuance() {
        return continuance;
    }
}
