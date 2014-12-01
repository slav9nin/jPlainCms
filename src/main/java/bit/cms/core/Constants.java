package bit.cms.core;

/**
 * Created by bito4ek on 23.11.14.
 */
public interface Constants {
    public static final String USER = "user";
    public static final String ADMIN = "admin";
    public static final String REMEMBER_ME = "remember-me";

    public static final String STATIC_PATH = "/static/";

    public static final int ITEMS_PER_PAGE = 20;

    public static final String EXCEPTION_ATTR = "loginException";

    public static final String LOGIN_PARAMETER = "login";
    public static final String PASSWD_PARAMETER = "password";
    public static final String RM_ME_PARAMETER = "remember-me";
    public static final String URL_PARAMETER = "url";

    public static final String DEFAULT_SERVLET = "/";
    public static final String LOGIN_SERVLET = "/login";
    public static final String SIGN_SERVLET = "/sign";
    public static final String LOGOUT_SERVLET = "/logout";
    public static final String EXCEPTION_SERVLET = "/exception";
    public static final String PAGE_CONTROLLER_SERVLET = "pages/";

    public static final String ADMIN_INDEX_PAGE = "/WEB-INF/page/admin/index.jsp";
    public static final String ERROR_PAGE = "/WEB-INF/page/composite/error.jsp";
    public static final String USER_PAGE = "/WEB-INF/page/composite/index.jsp";
    public static final String LOGIN_PAGE = "/WEB-INF/page/composite/login.jsp";
}
