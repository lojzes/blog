package com.lojzes.rpc.service;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class IStudentImpl implements IStudent {
    @Override
    public String getNameById(int id) {
        String st = "id:" + id + " name:" + "lojzes";
        return st;
    }
}
