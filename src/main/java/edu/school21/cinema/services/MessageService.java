package edu.school21.cinema.services;

import edu.school21.cinema.dto.MessageDTO;
import edu.school21.cinema.models.Message;
import edu.school21.cinema.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<MessageDTO> getAllMessagesByFilmId(int filmId) {
        return repository.getMessagesByFilmId(filmId);
    }

    @Transactional
    public void save(MessageDTO messageDTO) {
        repository.save(new Message(messageDTO.getMessage(), messageDTO.getFilmId(), messageDTO.getUserId()));
    }
}
