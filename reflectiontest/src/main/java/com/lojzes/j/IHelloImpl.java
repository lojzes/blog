package com.lojzes.j;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class IHelloImpl implements IHello {
    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }
}
