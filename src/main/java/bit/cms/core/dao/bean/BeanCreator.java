package bit.cms.core.dao.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Artem.Telizhenko
 *         Date: 17.11.2014
 *         Time: 22:31
 */
public interface BeanCreator<Class> {
    public Class getBean(ResultSet resultSet) throws SQLException;
}
