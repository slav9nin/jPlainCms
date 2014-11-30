package bit.cms.core.dao;

import bit.cms.core.dao.bean.UserBeanCreatorImpl;
import bit.cms.core.dao.domain.User;
import bit.cms.core.exception.UserNotFoundException;
import bit.cms.util.PrepareStatementUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 15:54
 */
public class MySqlUserDAO implements UserDAO {
    private static final long serialVersionUID = -1458260524640618820L;
    private Connection connection;

    public MySqlUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void insertUsers(Collection<User> users) {
//        PrepareStatementUtil.executeBatch();
    }

    @Override
    public User getUser(Long id) throws UserNotFoundException, SQLException {
        User user = PrepareStatementUtil.getBean(UserSQL.GET_USER_BY_ID, connection, new Object[]{id}, new UserBeanCreatorImpl());
        if (user == null)
            throw new UserNotFoundException("User not found by id");
        return user;
    }

    @Override
    public User getUser(String login, String password) throws UserNotFoundException, SQLException {
        User user = PrepareStatementUtil.getBean(UserSQL.GET_USER, connection, new Object[]{login, password}, new UserBeanCreatorImpl());
        if (user == null)
            throw new UserNotFoundException("Login or password is incorrect");
        return user;
    }

    @Override
    public List<User> getUsers(boolean isActive) throws SQLException {
        return PrepareStatementUtil.getResults(UserSQL.GET_ALL_USERS, connection, null, new UserBeanCreatorImpl());
    }

    @Override
    public void deactivateUser(User user) {

    }
}
