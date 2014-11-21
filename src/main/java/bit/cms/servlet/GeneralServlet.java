package bit.cms.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 9:38
 */
public abstract class GeneralServlet extends HttpServlet {
    private static final long serialVersionUID = 6615371722532028471L;

    public void generalDispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    public void redirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }

    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
