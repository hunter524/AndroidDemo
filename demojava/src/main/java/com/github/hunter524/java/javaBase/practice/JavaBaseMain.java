package com.github.hunter524.java.javaBase.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by hunter on 2016/10/11.
 */

public class JavaBaseMain {
    public static void main(String[] arg){
        People people = new People(){
            @Override
            public String getName() {
                return "people";
            }
        };

        getPeople(people);

        People students = new Students();
//        重载 与指针有关 与实例的对象类型无关。
        getPeople(students);
//demo for transient 关键字
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E://sutdent.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.flush();
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
