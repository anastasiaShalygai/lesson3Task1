package com.nastya_shalygai.java.lesson3.task1.study;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Anastasiya on 09.02.2017.
 */
public class IndividualProgram {
    public final int WORK_TIME_START = 10;
    public final int WORK_TIME_END = 18;
    private String name;
    private Date dateStart;
    private Courses[] program;

    public IndividualProgram(String name, Date dateStart) {
        this.name = name;
        this.dateStart = dateStart;
    }

    public void setProgram(Courses... courses) {
        Courses[] program = new Courses[courses.length];
        int i = 0;

        for (Courses course : courses) {
            program[i] = course;
            i++;
        }
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public int getSumContinuance() {
        int sumTime = 0;
        for (Courses continuance : program) {
            sumTime += continuance.getContinuance();
        }
        return sumTime;
    }

    /**
     * Method to convert String type in the Date
     * @param dateString - date value in a String
     * @return - date value in the type Date
     */
    public static Date convertStringToDate(String dateString) {
        try {
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = format.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = dateFormat.format(date);
        return dateString;
    }

    public Date getDateEnd() {
        int sumDay = getSumContinuance() / (WORK_TIME_END - WORK_TIME_START);

        Calendar instance = Calendar.getInstance();
        instance.setTime(dateStart);
        instance.add(Calendar.DAY_OF_MONTH, sumDay);
        return instance.getTime();
    }

    public int getDaysEndOfTheProgram() {
        Date newDate = new Date();
        long seconds = (newDate.getTime() - getDateEnd().getTime());
        long diffDays = seconds / (60 * 60 * 1000);
        return (int) diffDays;
    }
}
