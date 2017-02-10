package com.nastya_shalygai.java.lesson3.task1.student;

import com.nastya_shalygai.java.lesson3.task1.study.IndividualProgram;

import static java.lang.Math.abs;

/**
 * Created by Anastasiya on 09.02.2017.
 */
public class Student {
    private String initials;
    private IndividualProgram individualProgram;

    public Student(String initials, IndividualProgram individualProgram) {
        this.initials = initials;
        this.individualProgram = individualProgram;
    }

    public void printReport(int param) {
        if (param == 0) {
            System.out.print("\n" + initials + " (" + individualProgram.getName() + ")");

            if (individualProgram.getDaysEndOfTheProgram() <= 0)
                System.out.print("- Обучение не закончено. До окончания осталось ");
            else System.out.print("- Обучение закончено. После окончания прошло ");

            //Avoid hardcoded parameters
            //Notify me to tell you about String.format()
            System.out.print(abs(individualProgram.getDaysEndOfTheProgram() / 24) + " д " + abs(individualProgram.getDaysEndOfTheProgram() % 24) + " ч ");
        } else {
            System.out.print("\n ФИО: " + initials
                    + "\n Рабочее время: с " + individualProgram.WORK_TIME_START + " до " + individualProgram.WORK_TIME_END
                    + "\n Название программы: " + individualProgram.getName()
                    + "\n Длительность программы в часах: " + individualProgram.getSumContinuance() + " ч"
                    + "\n Дата старта: " + IndividualProgram.convertDateToString(individualProgram.getDateStart())
                    + "\n Дата завершения: " + IndividualProgram.convertDateToString(individualProgram.getDateEnd()));
            //Please, use {} braces after EVERY if-else statement - it is easily to read such code :)
            if (individualProgram.getDaysEndOfTheProgram() <= 0) System.out.print("\n До окончания осталось : ");
            else System.out.print("\n После окончания прошло: ");

            //Avoid hardcoded parameters
            System.out.print(abs(individualProgram.getDaysEndOfTheProgram() / 24) + " д " + abs(individualProgram.getDaysEndOfTheProgram() % 24) + " ч ");
            System.out.println("\n--------------------------------------------");
        }
    }
}
