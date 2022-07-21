package edu.school21.chat.repositories;

import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {
    private final Db_connection dataSource;

    public UserRepositoryJdbcImpl(Db_connection dataSource) {
        this.dataSource = dataSource;
    }

    public Optional<User> findById(int id)
    {
        try {
            String              SQL_QUERY = "SELECT * FROM users WHERE id = (?)";
            Connection connection = dataSource.getConnection();
            PreparedStatement pst = connection.prepareStatement(SQL_QUERY);

            pst.setLong(1, id);

            ResultSet resultSet = pst.executeQuery();
            User                user = null;

            if (resultSet.next()) {
                int        id_user = resultSet.getInt(1);
                String      name = resultSet.getString(2);
                String      password = resultSet.getString(3);

                user = new User(id_user, name, password, null, null);
            }

            pst.close();
            connection.close();

            return Optional.ofNullable(user);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
