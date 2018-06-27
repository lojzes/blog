package com.lojzes.rpc.client;

import java.lang.reflect.Proxy;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class RpcClientProxy {

    public static <T> T proxy(Class<T> interfaces,String host,int port){
        return (T)Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces},
                new ClientInterfaceHandler(host,port));
    }
}
