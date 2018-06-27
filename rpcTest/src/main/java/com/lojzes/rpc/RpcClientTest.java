package com.lojzes.rpc;

import com.lojzes.rpc.client.RpcClientProxy;
import com.lojzes.rpc.service.IStudent;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class RpcClientTest {
   public static void main(String[] args) {
        //生成代理
        IStudent proxy = RpcClientProxy.proxy(IStudent.class, "127.0.0.1", 9999);
        //远程调用
        String str = proxy.getNameById(2018);
        System.out.println("str = " + str);
    }
}
