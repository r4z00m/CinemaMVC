package edu.school21.cinema.dto;

import java.util.List;

public class SessionResponseDTO {
    List<SessionDTO> sessions;

    public SessionResponseDTO() {
    }

    public List<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDTO> sessions) {
        this.sessions = sessions;
    }
}
