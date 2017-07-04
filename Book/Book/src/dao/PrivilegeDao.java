package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zzp on 2017/3/27.
 */
public class PrivilegeDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

    //角色名称， 权限名称
    public boolean checkPrivilege(String role, String pname) throws SQLException {
        String sql = "select privileges.name from role, privileges, userprivilege where privileges.id" +
                "=userprivilege.privilege_id, and role.role=userprivilege.role and role.role=?";
        List<Object> pnames = queryRunner.query(sql, new ColumnListHandler(), role);
        return pnames.contains(pname);
    }

}
