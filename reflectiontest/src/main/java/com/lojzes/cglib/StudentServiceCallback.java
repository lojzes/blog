package com.lojzes.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 备注：cglib 对方法的拦截
 *
 * @author lyyitit@foxmail.com
 */
public class StudentServiceCallback implements MethodInterceptor {

    /**
     * 备注： obj：被增强后的对象
     *  method:被拦截的方法
     *  proxy：被拦截方法的代理
     * @author lyyitit@foxmail.com
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("方法执行之前--->>>");
        Object invoke = proxy.invokeSuper(obj, args);
        System.out.println("方法执行之后--->>>");
        return  invoke;
    }
}
