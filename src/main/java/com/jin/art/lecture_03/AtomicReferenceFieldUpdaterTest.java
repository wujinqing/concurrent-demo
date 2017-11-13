package com.jin.art.lecture_03;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author wu.jinqing
 * @date 2017年07月19日
 */
public class AtomicReferenceFieldUpdaterTest {
    private static AtomicReferenceFieldUpdater<User, String> updater = AtomicReferenceFieldUpdater.newUpdater(User.class, String.class, "name");

    public static void main(String[] args) {
        User user = new User("zhang san");
        System.out.println(user.getName());
        updater.getAndSet(user, "lisi");

        System.out.println(user.getName());
    }

    public static class User
    {
        public volatile String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
