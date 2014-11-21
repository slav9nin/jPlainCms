package bit.cms.core.dao.pool;

import bit.cms.core.dao.MySqlDAOFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Artem.Telizhenko
 *         Date: 17.11.2014
 *         Time: 21:26
 */
public class MysqlDataSource {
    private static MysqlDataSource instance;
    private ComboPooledDataSource dataSource;

    private MysqlDataSource() throws PropertyVetoException {
        dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(MySqlDAOFactory.DRIVER);
        dataSource.setJdbcUrl(MySqlDAOFactory.DB_URL);
        dataSource.setUser(MySqlDAOFactory.USER);
        dataSource.setPassword(MySqlDAOFactory.PASSWORD);

        dataSource.setMinPoolSize(5);
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxPoolSize(20);
        dataSource.setMaxStatements(180);
        dataSource.setCheckoutTimeout(1800);
        dataSource.setAcquireRetryAttempts(50);
        dataSource.setPreferredTestQuery("Select 1");
        dataSource.setCheckoutTimeout(1800);
    }

    public static MysqlDataSource getInstance() throws PropertyVetoException {
        if (instance == null)
            instance = new MysqlDataSource();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

}
