package bit.cms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static bit.cms.core.Constants.DEFAULT_SERVLET;

/**
 * Created by bito4ek on 30.11.14.
 */
public class LogoutServlet extends GeneralServlet {
    private static final long serialVersionUID = 4246336552667246788L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.logout();
        HttpSession session = request.getSession();
        session.invalidate();
        generalDispatch(request, response, DEFAULT_SERVLET);
    }
}
