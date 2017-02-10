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
     * @param dateString - date value in a String that have format dd.MM.yyyy
     * @return - date value in the type Date
     */
    public static Date convertStringToDate(String dateString) {
        try {
            //dd.MM.yyyy - can be a constant value, because it is using more than one time.
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
        // you can simplify by - return dateFormat.format(date);
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
        //Avoid magic numbers
        //Not exact var name was chosen. It may confuse your colleagues.
        //You probably get diffHours value?
        long diffDays = seconds / (60 * 60 * 1000);
        return (int) diffDays;
    }
}
