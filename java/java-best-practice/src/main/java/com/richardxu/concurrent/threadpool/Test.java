package com.richardxu.concurrent.threadpool;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        SimpleHttpServer.setBasePath("/Users/xufeng/DEV/www");
        SimpleHttpServer.setPort(8080);
        SimpleHttpServer.start();
    }
}