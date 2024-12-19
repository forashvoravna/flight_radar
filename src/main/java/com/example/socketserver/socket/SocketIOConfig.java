package com.example.socketserver.socket;


import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@org.springframework.context.annotation.Configuration
public class SocketIOConfig {
    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname("0.0.0.0");
        config.setPort(12345);
        return new SocketIOServer(config);
    }
}