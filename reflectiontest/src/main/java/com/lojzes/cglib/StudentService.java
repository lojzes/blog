package com.lojzes.cglib;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class StudentService {


    public void add(String name) {
        System.out.println("add --->>>" + name);
    }

    public int del(int id) {
        System.out.println("del --->>>" + id);
        return 0;
    }

    public String get(int id) {
        System.out.println("get --->>>" + id);
        return "hello";
    }

}
