package bit.cms.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static bit.cms.core.Constants.METHOD_NOT_SUPPORT;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 9:38
 */
public abstract class GeneralServlet extends HttpServlet {
    private static final long serialVersionUID = 6615371722532028471L;

    protected void generalDispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    protected void redirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }

    @Override
    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    protected void sendNotSupported(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, METHOD_NOT_SUPPORT);
    }
}
