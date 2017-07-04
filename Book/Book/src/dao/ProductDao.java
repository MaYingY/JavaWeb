package dao;

import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zzp on 2017/3/26.
 */
public class ProductDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

    public List<Product> findAll() throws SQLException {
        String sql = "select * from products";
        return queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
    }
}
