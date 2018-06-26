package com.lojzes.j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 备注：对接口实现类的InvocationHandler
 *
 * @author lyyitit@foxmail.com
 */
public class IHelloImplInvocationHandler implements InvocationHandler {
    //被代理对象
    private Object obj;

    //被代理对象通过构造方法传入
    public IHelloImplInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前--->>>");
        Object invoke = method.invoke(obj, args);
        System.out.println("方法执行后--->>>");
        return invoke;//返回值
    }
}
