package com.lojzes.j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 备注：单独对接口的InvocationHandler
 *
 * @author lyyitit@foxmail.com
 */
public class IHelloInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return "hello";//返回值
    }
}
