package com.example.socketserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.net.*;

@SpringBootApplication
public class SocketserverApplication {
    @Autowired
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SocketserverApplication.class, args);
        SocketServer socketServer = context.getBean(SocketServer.class);
        socketServer.start();
    }
}
