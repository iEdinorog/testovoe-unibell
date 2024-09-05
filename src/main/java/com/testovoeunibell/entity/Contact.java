package com.testovoeunibell.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private ContactType type;
}
