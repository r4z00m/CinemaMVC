package edu.school21.cinema.repositories;

import edu.school21.cinema.dto.MessageDTO;
import edu.school21.cinema.models.Message;

import java.util.List;

public interface MessageRepository {
    List<MessageDTO> getMessagesByFilmId(int filmId);

    void save(Message message);
}
