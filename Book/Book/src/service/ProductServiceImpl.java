package service;

import dao.ProductDao;
import domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zzp on 2017/3/26.
 */
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDao();
    //查找所有商品
    public List<Product> findAll() throws SQLException {
        return productDao.findAll();
    }
}
