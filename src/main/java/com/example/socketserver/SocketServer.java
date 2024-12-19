package com.example.socketserver;

import com.corundumstudio.socketio.SocketIOServer;
import com.example.socketserver.entity.AirportEntity;
import com.example.socketserver.entity.FlightEntity;
import com.example.socketserver.repository.AirportRepository;
import com.example.socketserver.repository.FlightRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
public class SocketServer {
    @Autowired
    private SocketIOServer socketIOServer;
    @Autowired
    private FlightRepository flyRadarRepository;

    @Autowired
    AirportRepository airportRepository;

    public void start() {
        try {
            DatagramSocket clientSocket = new DatagramSocket(1234);
            System.out.println("Socket server started on port " + 1234);
            handleClient(clientSocket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleClient(DatagramSocket clientSocket) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        while (true) {
            byte[] receiveData = new byte[1024];  // Qabul qilish uchun buffer

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);  // Bu metod bloklashadi, ma'lumot kelguncha kutadi
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            JsonNode rootNode = mapper.readTree(receivedMessage);
//            System.out.println(rootNode);
            if (rootNode.path("type").asText().equals("fly_radar")) {
                JsonNode fly_radar = rootNode.path("data");
                JsonNode createdAt = rootNode.path("createdAt");
                FlightEntity flyRadarEntity = mapper.treeToValue(fly_radar, FlightEntity.class);
                flyRadarEntity.setTime(createdAt.asText());
                flyRadarRepository.save(flyRadarEntity);
                socketIOServer.getBroadcastOperations().sendEvent("newRecord", flyRadarEntity);
            } else if (rootNode.path("type").asText().equals("airport")) {
                JsonNode airport = rootNode.path("data");
                AirportEntity airportEntity = mapper.treeToValue(airport, AirportEntity.class);
                airportRepository.save(airportEntity);
            }
        }
    }
}


