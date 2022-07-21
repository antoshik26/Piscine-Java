package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {
    private ProductsRepository  productsRepository;
    private final Product       EXPECTED_FIND_BY_ID_PRODUCT = new Product(0L, "ror", 34L);
    private final List<Product> EXPECTED_FIND_ALL_PRODUCTS = new ArrayList<>();
    private final Product       EXPECTED_UPDATED_PRODUCT = new Product(1L, "miss", 55L);

    public ProductsRepositoryJdbcImplTest() {
        EXPECTED_FIND_ALL_PRODUCTS.add(new Product(0L, "ror", 34L));
        EXPECTED_FIND_ALL_PRODUCTS.add(new Product(1L, "kek", 4L));
        EXPECTED_FIND_ALL_PRODUCTS.add(new Product(2L, "slip", 423L));
        EXPECTED_FIND_ALL_PRODUCTS.add(new Product(3L, "dog", 23L));
        EXPECTED_FIND_ALL_PRODUCTS.add(new Product(4L, "cat", 23453L));
        EXPECTED_FIND_ALL_PRODUCTS.add(new Product(5L, "lock", 898L));
    }

    @Test
    @BeforeEach
    public void init() throws SQLException {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .generateUniqueName(true)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();

        Assertions.assertNotNull(dataSource.getConnection());

        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    public void checkFindById() {
        Product result = productsRepository.findById(EXPECTED_FIND_BY_ID_PRODUCT.getId()).orElse(null);

        Assertions.assertEquals(result, EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    public void checkFindALL() {
        Assertions.assertEquals(productsRepository.findAll(), EXPECTED_FIND_ALL_PRODUCTS);
    }

    @Test
    public void checkUpdate() {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);

        Product product = productsRepository.findById(EXPECTED_UPDATED_PRODUCT.getId()).orElse(null);

        Assertions.assertEquals(product, EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    public void checkSave() {
        Product             productSave = new Product(34L, "james", 345L);

        productsRepository.save(productSave);

        Product productFind = productsRepository.findById(productSave.getId()).orElse(null);

        Assertions.assertEquals(productSave, productFind);
    }

    @Test
    public void checkDelete() {
        productsRepository.delete(EXPECTED_FIND_BY_ID_PRODUCT.getId());

        Product find = productsRepository.findById(EXPECTED_FIND_BY_ID_PRODUCT.getId()).orElse(null);

        Assertions.assertNull(find);
    }
}