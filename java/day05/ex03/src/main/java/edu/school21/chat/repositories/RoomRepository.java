package edu.school21.chat.repositories;

import edu.school21.chat.models.Room;

import java.util.Optional;

public interface RoomRepository {
    Optional<Room> findById(int id);
}
