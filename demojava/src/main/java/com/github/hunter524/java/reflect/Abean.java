package com.github.hunter524.java.reflect;


/**
 * Created by hunter on 2017/2/24.
 */

public class Abean {
    private String name ;
    private String sex ;
    private String year;
    private String skinColor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    @Override
    public String toString() {
        return "Abean{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", year='" + year + '\'' +
                ", skinColor='" + skinColor + '\'' +
                '}';
    }

    public static class SuperClass{
        public static int A = 123;
    }

    public interface ISuper1{
        int A = 123;
    }
    public interface ISuper2 extends ISuper1{
        int A = 123;
    }
    public static class SubClass extends SuperClass implements ISuper2{
        public static int A = 123;
        static {
            A = 456;
            System.out.println(A);
        }
    }
}
