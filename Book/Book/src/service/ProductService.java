package service;

import domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zzp on 2017/3/26.
 */
public interface ProductService {

    //查找商品
    List<Product> findAll() throws SQLException;
}
