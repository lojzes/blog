package com.lojzes.rpc;

import com.lojzes.rpc.server.RpcServer;
import com.lojzes.rpc.service.IStudent;
import com.lojzes.rpc.service.IStudentImpl;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class RpcServerTest {
    public static void main(String[] args) {
        IStudent iStudent = new IStudentImpl();
        //发布服务
        RpcServer.publish(iStudent, 9999);
    }
}
