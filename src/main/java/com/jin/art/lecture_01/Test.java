package com.jin.art.lecture_01;

/**
 * @author wu.jinqing
 * @date 2017年06月26日
 */
public class Test {
    volatile static Student student;
    public static void main(String[] args) {

        new Thread(() -> {
            student = new Student("zhang san", 20);
        }).start();

        for(int i = 0; i < 100000000; i++)
        {
            int j = i + i;
        }

        Thread t1 = new MyThread(student);

        Thread t2 = new MyThread(student);

        t2.start();
        t1.start();

    }


}

class Student
{
    private String name;
    private int age;

    public Student(String name, int age) {

        this.name = name;
        for(int i = 0; i < 1000000000; i++)
        {
            int j = i + i;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class MyThread extends Thread
{
    private Student student;

    MyThread (Student student)
    {
        this.student = student;
    }

    @Override
    public void run() {

        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
