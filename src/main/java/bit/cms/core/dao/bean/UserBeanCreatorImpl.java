package bit.cms.core.dao.bean;

import bit.cms.core.dao.domain.Role;
import bit.cms.core.dao.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Artem.Telizhenko
 *         Date: 18.11.2014
 *         Time: 17:18
 */
public class UserBeanCreatorImpl implements BeanCreator<User> {
    @Override
    public User getBean(ResultSet resultSet) throws SQLException {
        User user = new User();
        Role role = new Role();

        user.setId(resultSet.getLong("USER_ID"));
        user.setLogin(resultSet.getString("LOGIN"));
        user.setPassword(resultSet.getString("PASSWORD"));
        user.setFirstName(resultSet.getString("FIRST_NAME"));
        user.setMiddleName(resultSet.getString("MIDDLE_NAME"));
        user.setLastName(resultSet.getString("LAST_NAME"));
        user.setActive(resultSet.getString("USER_ACTIVE").charAt(0) == 'Y');

        role.setId(resultSet.getLong("ROLE_ID"));
        role.setRoleName(resultSet.getString("ROLE_NAME"));
        role.setActive(resultSet.getString("ROLE_ACTIVE").charAt(0) == 'Y');

        user.setUserRole(role);
        return user;
    }
}
