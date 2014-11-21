package bit.cms.core.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 17:51
 */
public interface DAO extends Serializable {
    UserDAO getUserDAO() throws SQLException;
}
