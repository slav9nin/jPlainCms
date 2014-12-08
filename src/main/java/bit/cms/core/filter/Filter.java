package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.exception.UserIsNotAdminException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:47
 */
public interface Filter extends Serializable {

    public void execute(ServletRequest request, ServletResponse response)
            throws AuthenticationException, UserIsNotAdminException;
}
