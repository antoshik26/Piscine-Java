package edu.school21.chat.repositories;
import edu.school21.chat.models.Messages;
import edu.school21.chat.models.User;
import edu.school21.chat.models.Room;
import javax.sql.DataSource;
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

            pst.setLong(1, id);

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

}
