package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.Md5Utils;

import java.sql.SQLException;

/**
 * Created by zzp on 2017/4/10.
 */
public class UserDao {
    QueryRunner queryRunner = new TxQueryRunner();
    public void addUser(User user) throws SQLException {
        String sql = "insert into users values(null, ?,?,?,?, 'user','0',?,null)";
        queryRunner.update(sql, user.getUsername(),
                Md5Utils.md5(user.getPassword()),
                user.getNickname(),
                user.getEmail(),
                user.getActivecode());
    }
}
