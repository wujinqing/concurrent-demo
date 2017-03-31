package com.jin.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wu.jinqing
 * @date 2017年03月21日
 */
public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");

        field.setAccessible(true);

        Unsafe theUnsafe = (Unsafe)field.get(null);

        System.out.println(theUnsafe);

//        // 通过反射得到theUnsafe对应的Field对象
//        Field field = Unsafe.class.getDeclaredField("theUnsafe");
//        // 设置该Field为可访问
//        field.setAccessible(true);
//        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
//        Unsafe unsafe = (Unsafe) field.get(null);
//        System.out.println(unsafe);

        User user = (User) theUnsafe.allocateInstance(User.class);
        user.setAge(123);
        user.setName("zhang san");
        System.out.println(user);

        User theUser = new User();

        System.out.println(theUser);
    }


    static class User {
        private String name = "";
        private int age = 0;

        public User() {
            this.name = "test";
            this.age = 22;
        }

        @Override
        public String toString() {
            return name + ": " + age;
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

}
