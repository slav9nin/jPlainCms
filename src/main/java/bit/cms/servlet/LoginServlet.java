package bit.cms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static bit.cms.core.Constants.LOGIN_PAGE;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 22:04
 */
public class LoginServlet extends GeneralServlet {
    private static final long serialVersionUID = 2238643888285198412L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(LOGIN_PAGE).include(request, response);
    }
}
