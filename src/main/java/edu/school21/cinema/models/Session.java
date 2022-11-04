package edu.school21.cinema.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "hall_id")
    private Hall hall;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    private int cost;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
