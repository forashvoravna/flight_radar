package com.example.socketserver.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String createdAt;

    @Lob
    private String data;
}