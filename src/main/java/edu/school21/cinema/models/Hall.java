package edu.school21.cinema.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "hall")
    private List<Session> sessions;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
