package webshop;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(MariaDbDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement("insert into products (product_name, price, stock) values (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, productName);
                ps.setInt(2, price);
                ps.setInt(3, stock);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public Product findProductById(long id) {
        return jdbcTemplate.query("select * from products where id = ?", (rs, rowNum) -> {
            String productName = rs.getString("product_name");
            int price = rs.getInt("price");
            int stock = rs.getInt("stock");
            return new Product(id, productName, price, stock);
        }, id).get(0);
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("update products set stock = (stock - ?) where id = ?", amount, id);
    }
}
