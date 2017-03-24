package com.github.hunter524.java.Collections;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hunter on 2017/3/22.
 */

public class ComparatorDemo {

    public static List<String> mStrList = Arrays.asList("1","5","3","2","4");
    public static List<CompareBean> compareBeanList = Arrays.asList(
            new CompareBean(1),new CompareBean(5),new CompareBean(3),new CompareBean(2),
            new CompareBean(4),new CompareBean(0));
    public static void demo(){
        Comparator<String> strComparator = new Comparator<String>() {
//            o1>o2 升序
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Collections.sort(mStrList,strComparator);
        System.out.println(mStrList);
        Collections.sort(compareBeanList);
        System.out.println(compareBeanList);

    }

//this > o 升序
    public static class CompareBean implements Comparable<CompareBean>{
        int year;

        public CompareBean(int year) {
            this.year = year;
        }

        @Override
        public int compareTo(CompareBean o) {
            if (this.year>o.year){
                return 1;
            }
            else if (this.year == o.year){
                return 0;
            }
            else if (this.year<o.year){
                return -1;
            }
            else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return Integer.toString(this.year);
        }
    }
}
