package edu.school21.cinema.repositories;

import edu.school21.cinema.dto.MessageDTO;
import edu.school21.cinema.models.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MessageDTO> getMessagesByFilmId(int filmId) {
        return entityManager.createQuery("select m from Message m where m.filmId = :filmId order by m.id desc", Message.class)
                .setParameter("filmId", filmId)
                .setMaxResults(20)
                .getResultStream()
                .map(message -> new MessageDTO(
                        message.getId(),
                        message.getMessage(),
                        message.getFilmId(),
                        message.getUserId()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Message message) {
        entityManager.persist(message);
    }
}
