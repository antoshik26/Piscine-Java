package school21.spring.service.repositories;

import org.jetbrains.annotations.NotNull;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository{
    private DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource ds){
        this.dataSource = ds;
    }
    public User findById(long Id){
        try {
            String SQL_QUERY = "SELECT * FROM User WHERE id = (?)";
            Connection connection = dataSource.getConnection();
            PreparedStatement pst = connection.prepareStatement(SQL_QUERY);

            pst.setLong(1, Id);

            ResultSet resultSet = pst.executeQuery();
            User user = null;

            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String email = resultSet.getString(2);

                user = new User(id, email);
            }

            pst.close();
            connection.close();

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<User> findAll(){
        final String QUERY = "SELECT * FROM public.user";
        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(QUERY)) {
            ResultSet results = pst.executeQuery();
            while (results.next()) {
                Long id = results.getLong(1);
                String email = results.getString(2);
                users.add(new User(id, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void save(User entity){
        String  query = "INSERT INTO messages(id, email) VALUES ((?), (?)) RETURNING id";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(1, entity.getId());
            pst.setString(2, entity.getEmail());

            try {
                pst.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.exit(-1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(User entity){
        String  query = "UPDATE messages SET email = (?) WHERE id = (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setLong(2, entity.getId());
            pst.setString(1, entity.getEmail());

            try {
                pst.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.exit(-1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
    public void delete(User entity){
        String QUERY = "DELETE FROM user WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(QUERY)) {
            pst.setLong(1, entity.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    @Override
    public Optional<User> findByEmail(String email) {
        String QUERY = "SELECT * FROM public.user WHERE email=" + "'" + email + "'";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(QUERY);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getLong(1),
                        resultSet.getString(2));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
