package edu.school21.chat.repositories;
import edu.school21.chat.models.Messages;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Messages> findById(int id);
    public void save(Messages message) throws SQLException;
}
