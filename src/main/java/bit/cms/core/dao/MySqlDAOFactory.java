package bit.cms.core.dao;

import bit.cms.core.dao.pool.MysqlDataSource;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 15:53
 */
public class MySqlDAOFactory implements DAO {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/javaCms";
    public static final String USER = "javaCms";
    public static final String PASSWORD = "javaCms";
    private static final long serialVersionUID = 7276471977257766276L;
    private MysqlDataSource dataSource;

    public MySqlDAOFactory() {
        try {
            this.dataSource = MysqlDataSource.getInstance();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDAO getUserDAO() throws SQLException {
        return new MySqlUserDAO(dataSource.getConnection());
    }
}
