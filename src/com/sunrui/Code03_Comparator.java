package com.sunrui;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Code03_Comparator {
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name , int id , int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendComparator implements Comparator<Student>{
        //返回负数的时候，第一个参数排在前面
        //返回正数的时候，第二个参数排在前面
        //返回0的时候谁在前面无所谓
        @Override
        public int compare(Student o1 , Student o2){
//            return o1.id-o2.id;
            if(o1.id < o2.id){
                return -1;
            }
            if(o2.id < o1.id){
                return 1;
            }
            return 0;
        }
    }

    public static class IdDescendComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1 , Student o2){
           return o2.id-o1.id;
        }
    }

    public static class AgeAscendComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1 , Student o2){
            return o1.age-o2.age;
        }
    }

    public static class AgeDescendComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1 , Student o2){
            return o2.age-o1.age;
        }
    }

    public static class AgeShengIdSheng implements Comparator<Student>{
        @Override
        public int compare(Student o1 , Student o2){
            return o1.age != o2.age ? (o1.age - o2.age) : (o1.id-o2.id);
        }
    }

    //先按照id排序，id小的，放前面
    //id一样，age大的，放前面
    public static class IdInAgeDe implements Comparator<Student>{
        @Override
        public int compare(Student o1 , Student o2){
            return o1.id != o2.id ? o1.id - o2.id : (o2.age - o1.age);
        }
    }

    public static void printStudents(Student[] students){
        for(Student student: students){
            System.out.println("Name :" + student.name + ", ID : " + student.id + ",Age : " + student.age);
        }
    }

    public static void printArray(Integer[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static class MyComp implements Comparator<Integer>{

        @Override
        public int compare(Integer o1 , Integer o2){
            return o2 - o1;
        }
    }

    public static class AComp implements Comparator<Integer>{
        //返回负数的时候，认为第一个参数排在前面
        //返回正数的时候，认为第二个参数排在前面
        //返回0的时候谁在前面无所谓
        @Override
        public int compare(Integer arg0 , Integer arg1){
            return arg1 - arg0;
//            return 0;
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {5,4,3,2,7,9,1,0};

        //默认的方法升序
        Arrays.sort(arr);
        Arrays.sort(arr, new AComp());

        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
        System.out.println("================");

        Student student1 = new Student("A" , 2 , 20);
        Student student2 = new Student("B" , 3 , 21);
        Student student3 = new Student("C" , 1 , 22);
        Student[] students = new Student[]{student1,student2,student3};
        System.out.println("第一条打印");

        Arrays.sort(students,new IdDescendComparator());
        printStudents(students);
        System.out.println("=================");

        Arrays.sort(students,new IdAscendComparator());
        printStudents(students);
        System.out.println("=================");

        Arrays.sort(students,new AgeAscendComparator());
        printStudents(students);
        System.out.println("===================");

        PriorityQueue<Student> minHeapBasedAge = new PriorityQueue<>(new AgeAscendComparator());
        minHeapBasedAge.add(student1);
        minHeapBasedAge.add(student2);
        minHeapBasedAge.add(student3);
        while(!minHeapBasedAge.isEmpty()){
            Student student = minHeapBasedAge.poll();
            System.out.println("Name: "+student.name + ", ID: "+student.id+", Age: "+student.age);
        }
        System.out.println("=================");
        System.out.println("=================");
        System.out.println("=================");

        TreeSet<Student> treeAgeDescending = new TreeSet<>(new AgeAscendComparator());
        treeAgeDescending.add(student1);
        treeAgeDescending.add(student2);
        treeAgeDescending.add(student3);

        Student studentFirst = treeAgeDescending.first();
        System.out.println("Name : "+studentFirst.name + ", Id: "+studentFirst.id+", Age: "+studentFirst.age);

        Student studentLast = treeAgeDescending.last();
        System.out.println("Name : "+studentLast.name+", Id: "+studentLast.id+", Age: "+studentLast.age);
        System.out.println("=================");
    }
}
