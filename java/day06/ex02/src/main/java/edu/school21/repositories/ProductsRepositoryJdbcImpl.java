package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {
    private DataSource dataSource;
    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> findAll() {
        List<Product>   list = new ArrayList<>();
        String          QUERY = "SELECT * FROM product";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(QUERY)) {

            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                list.add(new Product(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getLong(3)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Product> findById(Long id)
    {
        try {
            String              SQL_QUERY = "SELECT * FROM Product WHERE id = (?)";
            Connection connection = dataSource.getConnection();
            PreparedStatement pst = connection.prepareStatement(SQL_QUERY);

            pst.setLong(1, id);

            ResultSet resultSet = pst.executeQuery();
            Product             product = null;

            if (resultSet.next()) {
                Long         id_message = resultSet.getLong(1);
                String      text = resultSet.getString(2);
                Long Price = resultSet.getLong(3);
                product = new Product(id_message, text, Price);
            }

            pst.close();
            connection.close();

            return Optional.ofNullable(product);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
        String  query = "INSERT INTO Product(NameProduct, Price) VALUES ((?), (?)) RETURNING id";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, product.getName());
            pst.setLong(2, product.getPryce());

            try {
                ResultSet   resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    product.setId(resultSet.getLong(1));
                }

            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.exit(-1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Product product){
        String  query = "UPDATE Product SET NameProduct = (?), Price = (?) WHERE id = (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, product.getName());
            pst.setLong(2, product.getPryce());
            pst.setLong(3, product.getId());

            try {
                ResultSet   resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    product.setId(resultSet.getLong(1));
                }

            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.exit(-1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Long id){
        String  query = "Delete from Product WHERE id = (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, id);
            try {
               pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.exit(-1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
