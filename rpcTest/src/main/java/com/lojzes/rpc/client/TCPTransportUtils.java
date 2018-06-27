package com.lojzes.rpc.client;

import com.lojzes.rpc.utils.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class TCPTransportUtils {
    private String host;
    private int port;

    public TCPTransportUtils(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket newSocket() {

        Socket socket = null;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return socket;
    }

    public Object send(RpcRequest rpcRequest) {
        Socket socket = newSocket();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            //从服务端返回
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object o = objectInputStream.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
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
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
