package com.lojzes;

import com.lojzes.j.IHello;
import com.lojzes.j.IHelloImpl;
import com.lojzes.j.IHelloImplInvocationHandler;
import com.lojzes.j.IHelloInvocationHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * 备注：动态代理回顾
 *
 * @author lyyitit@foxmail.com
 */
public class ProxyTest {

    /**
    * 备注： 只有接口，没有实现类的代理
    *
    * @author lyyitit@foxmail.com
    */
    @Test
    public void test01() {
        IHello iHello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[]{IHello.class},
                new IHelloInvocationHandler());
        String rn = iHello.sayHello("test");
        System.out.println("返回值 --->>>" + rn);

    }

    /**
    * 备注：对接口实现类的代理
    *
    * @author lyyitit@foxmail.com
    */
    @Test
    public void test02() {
        IHello iHelloImpl = new IHelloImpl();
        IHello iHello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[]{IHello.class},
                new IHelloImplInvocationHandler(iHelloImpl));
        String rn = iHello.sayHello("test");
        System.out.println("返回值 --->>>" + rn);

    }


}
