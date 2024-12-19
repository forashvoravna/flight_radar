package com.example.socketserver.socket;

import com.corundumstudio.socketio.SocketIOServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


@Component
public class SocketIOController {

    private final SocketIOServer socketIOServer;

    public SocketIOController(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @PostConstruct
    public void startSocketServer() {
        socketIOServer.start();
        System.out.println("Socket.IO server started on port 12345");
    }

    @PreDestroy
    public void stopSocketServer() {
        socketIOServer.stop();
        System.out.println("Socket.IO server stopped.");
    }
}
