package com.lojzes.rpc.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class RpcServer {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void publish(Object service, int port) {
        InputStream inputStream = null;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("server started.....");
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ThreadHandler(service, socket));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
    }
}
