package edu.school21.chat.repositories;
import edu.school21.chat.models.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RoomReposirotyJdbcImpl implements RoomRepository{
    private final Db_connection dataSource;

    public RoomReposirotyJdbcImpl(Db_connection dataSource) {
        this.dataSource = dataSource;
    }
    public Optional<Room> findById(int id) {
        try {
            String              SQL_QUERY = "SELECT * FROM chatrooms WHERE id = (?)";
            Connection          connection = dataSource.getConnection();
            PreparedStatement   pst = connection.prepareStatement(SQL_QUERY);

            pst.setLong(1, id);

            ResultSet           resultSet = pst.executeQuery();
            Room            room = null;

            if (resultSet.next()) {
                int id_chat = resultSet.getInt(1);
                String  name = resultSet.getString(2);

                room = new Room(id_chat, name, null, null);
            }

            pst.close();
            connection.close();

            return Optional.ofNullable(room);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
