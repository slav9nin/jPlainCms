package bit.cms.core.dao;

import bit.cms.core.dao.domain.User;
import bit.cms.core.exception.UserNotFoundException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 15:30
 */
public interface UserDAO extends Serializable {

    public void createUser(User user);

    public void insertUsers(Collection<User> users);

    public User getUser(Long id) throws UserNotFoundException, SQLException;

    public User getUser(String login, String password) throws UserNotFoundException, SQLException;

    public List<User> getUsers(boolean isActive) throws SQLException;

    public void deactivateUser(User user);

}
