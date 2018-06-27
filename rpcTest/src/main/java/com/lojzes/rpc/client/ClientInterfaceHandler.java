package com.lojzes.rpc.client;

import com.lojzes.rpc.utils.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class ClientInterfaceHandler implements InvocationHandler {

    private String host;
    private int port;


    public ClientInterfaceHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TCPTransportUtils tcpTransportUtils = new TCPTransportUtils(host,port);
        RpcRequest request = new RpcRequest();
        request.setMethodName(method.getName());
        request.setArgsTypes(method.getParameterTypes());
        request.setArgs(args);
        request.setClassName(method.getDeclaringClass().getName());
        return tcpTransportUtils.send(request);
    }
}
