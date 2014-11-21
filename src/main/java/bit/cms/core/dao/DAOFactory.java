package bit.cms.core.dao;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 15:27
 */
public class DAOFactory {

    public static DAO getDAOFactory(DataBaseType type) {
        if (type != null) {
            switch (type) {
                case MY_SQL:
                    return new MySqlDAOFactory();
                case ORACLE:
            }
        }
        return null;
    }
}
