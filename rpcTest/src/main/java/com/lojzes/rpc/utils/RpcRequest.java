package com.lojzes.rpc.utils;

import java.io.Serializable;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 5523770308345478012L;
    //发布的服务
    private String className;
    //方法名称
    private String methodName;
    //方法参数类型
    private Class[] argsTypes;
    //方法参数
    private Object[] args;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class[] getArgsTypes() {
        return argsTypes;
    }

    public void setArgsTypes(Class[] argsTypes) {
        this.argsTypes = argsTypes;
    }
}
