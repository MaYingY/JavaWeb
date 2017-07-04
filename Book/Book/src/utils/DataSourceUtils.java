package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zzp on 2017/3/26.
 */
public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static DataSource getDataSource(){
        return dataSource;
    }
    /**
     * 当需要手动控制事务时，调用该方法获得一个链接
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();

        if(connection == null){
            connection = (Connection) dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
    //开启事务
    public static void startTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }
    //事务回滚
    public static void rollback() throws SQLException {
        getConnection().rollback();
    }
    //事务提交
    public static void commitAndReleased() throws SQLException {
        getConnection().commit();
        getConnection().close();
        threadLocal.remove();
    }
}
