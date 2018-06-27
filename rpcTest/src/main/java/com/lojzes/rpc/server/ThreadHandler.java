package com.lojzes.rpc.server;

import com.lojzes.rpc.utils.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class ThreadHandler implements Runnable {

    private Object service;
    private Socket socket;


    public ThreadHandler(Object service, Socket socket) {
        this.service = service;
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest) objectInputStream.readObject();
            String methodName = request.getMethodName();
            Class[] argsTypes = request.getArgsTypes();
            Object[] args = request.getArgs();

            Method method = service.getClass().getMethod(methodName, argsTypes);
            Object obj = method.invoke(service, args);
            outputStream = new ObjectOutputStream(socket.getOutputStream());

            outputStream.writeObject(obj);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
