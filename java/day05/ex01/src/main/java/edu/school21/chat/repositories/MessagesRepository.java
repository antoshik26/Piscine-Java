package edu.school21.chat.repositories;
import edu.school21.chat.models.Messages;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Messages> findById(int id);
}
