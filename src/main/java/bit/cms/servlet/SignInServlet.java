package bit.cms.servlet;

import bit.cms.bean.ParameterBean;
import bit.cms.core.dao.DAOFactory;
import bit.cms.core.dao.DataBaseType;
import bit.cms.core.dao.domain.User;
import bit.cms.core.exception.UserNotFoundException;
import bit.cms.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static bit.cms.core.Constants.*;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 22:10
 */
public class SignInServlet extends GeneralServlet {
    private static final long serialVersionUID = 543003230913635791L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWD_PARAMETER);
        boolean remember = RM_ME_PARAMETER.equals(request.getParameter(RM_ME_PARAMETER));
        String urlToRedirect = request.getParameter(URL_PARAMETER);

        try {
            User user = DAOFactory.getDAOFactory(DataBaseType.MY_SQL).getUserDAO().getUser(login, new MD5Util(password).compute());
//            request.login(login, password);
            HttpSession session = request.getSession(true);
            session.setAttribute(USER, new ParameterBean<User>(USER, user));
            session.setAttribute(REMEMBER_ME, new ParameterBean<Boolean>(REMEMBER_ME, remember));
            if (urlToRedirect != null) {
                redirect(response, urlToRedirect);
            } else {
                String page = PAGE_CONTROLLER_SERVLET;
                if (user.getUserRole().getId() == 1L)
                    page += ADMIN;
                else
                    page += USER;
                redirect(response, page);
            }
        } catch (UserNotFoundException | SQLException e) {
            request.setAttribute(EXCEPTION_ATTR, e.getMessage());
            generalDispatch(request, response, LOGIN_SERVLET);
        }
    }
}
