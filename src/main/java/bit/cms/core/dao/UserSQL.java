package bit.cms.core.dao;

/**
 * @author Artem.Telizhenko
 *         Date: 17.11.2014
 *         Time: 22:49
 */
public interface UserSQL {
    public static final String GET_ALL_USERS = "SELECT\n" +
            "  u.id          AS USER_ID,\n" +
            "  u.login       AS LOGIN,\n" +
            "  u.password    AS PASSWORD,\n" +
            "  u.first_name  AS FIRST_NAME,\n" +
            "  u.middle_name AS MIDDLE_NAME,\n" +
            "  u.last_name   AS LAST_NAME,\n" +
            "  u.role_id     AS ROLE_ID,\n" +
            "  u.active      AS USER_ACTIVE,\n" +
            "  r.name        AS ROLE_NAME,\n" +
            "  r.active      AS ROLE_ACTIVE,\n" +
            "  r.is_admin      AS ROLE_ADMIN\n" +
            "FROM cms_users u INNER JOIN cms_roles r ON u.role_id = r.id WHERE u.active = '?' AND r.active = 'Y'";
    public static final String GET_USER = "SELECT\n" +
            "  u.id          AS USER_ID,\n" +
            "  u.login       AS LOGIN,\n" +
            "  u.password    AS PASSWORD,\n" +
            "  u.first_name  AS FIRST_NAME,\n" +
            "  u.middle_name AS MIDDLE_NAME,\n" +
            "  u.last_name   AS LAST_NAME,\n" +
            "  u.role_id     AS ROLE_ID,\n" +
            "  u.active      AS USER_ACTIVE,\n" +
            "  r.name        AS ROLE_NAME,\n" +
            "  r.active      AS ROLE_ACTIVE,\n" +
            "  r.is_admin      AS ROLE_ADMIN\n" +
            "FROM cms_users u INNER JOIN cms_roles r ON u.role_id = r.id WHERE u.login = ? AND u.password = ? AND r.active = 'Y' AND u.active = 'Y'";
    public static final String GET_USER_BY_ID = "SELECT\n" +
            "  u.id          AS USER_ID,\n" +
            "  u.login       AS LOGIN,\n" +
            "  u.password    AS PASSWORD,\n" +
            "  u.first_name  AS FIRST_NAME,\n" +
            "  u.middle_name AS MIDDLE_NAME,\n" +
            "  u.last_name   AS LAST_NAME,\n" +
            "  u.role_id     AS ROLE_ID,\n" +
            "  u.active      AS USER_ACTIVE,\n" +
            "  r.name        AS ROLE_NAME,\n" +
            "  r.active      AS ROLE_ACTIVE,\n" +
            "  r.is_admin      AS ROLE_ADMIN\n" +
            "FROM cms_users u INNER JOIN cms_roles r ON u.role_id = r.id WHERE u.id = ? AND r.active = 'Y' AND u.active = 'Y'";
}
