package bit.cms.core.controller;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 21:51
 */
public interface Controller {
    public String getPage(RequestResponseHelper helper) throws ServletException, IOException;

    public static final String USER = "user";
    public static final String ADMIN = "admin";
}
