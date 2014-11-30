package bit.cms.core.controller;

import bit.cms.core.helper.Helper;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 21:51
 */
public interface Controller {
    public String getPage(Helper helper) throws ServletException, IOException;

}
