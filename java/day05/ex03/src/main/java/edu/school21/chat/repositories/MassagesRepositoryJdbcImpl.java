package edu.school21.chat.repositories;

import edu.school21.chat.models.Messages;
import edu.school21.chat.models.Room;
import edu.school21.chat.models.User;

import java.sql.*;
import java.util.Optional;


public class MassagesRepositoryJdbcImpl implements MessagesRepository {
    private final Db_connection dataSource;
    public MassagesRepositoryJdbcImpl(Db_connection dataSource) {
        this.dataSource = dataSource;
    }

    public Optional<Messages> findById(int id)
    {
        try {
            String              SQL_QUERY = "SELECT * FROM messages WHERE id = (?)";
            Connection connection = dataSource.getConnection();
            PreparedStatement pst = connection.prepareStatement(SQL_QUERY);

            pst.setInt(1, id);

            ResultSet resultSet = pst.executeQuery();
            Messages             message = null;

            if (resultSet.next()) {
                int         id_message = resultSet.getInt(1);
                int        id_author = resultSet.getInt(2);
                int        id_chatroom = resultSet.getInt(3);
                String      text = resultSet.getString(4);
                Timestamp date = resultSet.getTimestamp(5);

                UserRepository     usersRepository = new UserRepositoryJdbcImpl(dataSource);
                User                user = usersRepository.findById(id_author).orElse(null);

                RoomRepository RoomRepository = new RoomReposirotyJdbcImpl(dataSource);
                Room            chatroom = RoomRepository.findById(id_chatroom).orElse(null);

                message = new Messages(id_message, user, chatroom, text, date);
            }

            pst.close();
            connection.close();

            return Optional.ofNullable(message);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Messages message) throws SQLException {
        String  query = "INSERT INTO messages(author, room, text, date) VALUES ((?), (?), (?), (?)) RETURNING id";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, message.getIdCreatMessages().getID());
            pst.setInt(2, message.getIdRoomMassages().getId());
            pst.setString(3, message.getTextMassages());
            pst.setTimestamp(4, message.getDataMassages());

            try {
                ResultSet   resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    message.setId(resultSet.getInt(1));
                }

            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.exit(-1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Messages message) throws SQLException {
        String  query = "UPDATE messages SET author = (?), room = (?), text = (?), date = (?) WHERE id = (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, message.getIdCreatMessages().getID());
            pst.setInt(2, message.getIdRoomMassages().getId());
            pst.setString(3, message.getTextMassages());
            pst.setTimestamp(4, message.getDataMassages());

            try {
                ResultSet   resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    message.setId(resultSet.getInt(1));
                }

            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.exit(-1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
