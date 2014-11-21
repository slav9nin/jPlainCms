package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:47
 */
public interface Filter {
    public void execute(ServletRequest request, ServletResponse response) throws AuthenticationException;
}
