package com.xu.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author: canjin
 * @Date: 2021/2/26
 * 说明:
 */
public class NIO {
    public static void main(String[] args) {

        try {
            ServerSocketChannel server=ServerSocketChannel.open();

            server.configureBlocking(false);
            server.bind(new InetSocketAddress(8090));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
