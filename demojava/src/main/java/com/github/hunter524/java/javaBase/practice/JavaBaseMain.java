package com.github.hunter524.java.javaBase.practice;

/**
 * Created by hunter on 2016/10/11.
 */

public class JavaBaseMain {
    public static void main(){
        People people = new People(){
            @Override
            public String getName() {
                return "";
            }
        };

        getPeople(people);

        Students students = new Students();
        getPeople(students);

        Teachers teachers = new Teachers();
        getPeople(teachers);
    }
    public static void getPeople(People people){
        System.out.println("getPeople people");
        people.getName();
    }

    public static void getPeople(Teachers teachers){
        System.out.println("getPeople teachers");
        teachers.getName();
    }

    public static void getPeople(Students students){
        System.out.println("getPeople students");
        students.getName();
    }
}
