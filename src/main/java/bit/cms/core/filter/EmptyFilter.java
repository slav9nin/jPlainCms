package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author artem.telizhenko
 *         Date: 02.12.2014
 *         Time: 14:19
 */
public class EmptyFilter implements Filter {
    @Override
    public void execute(ServletRequest request, ServletResponse response) throws AuthenticationException {
        //nothing
    }
}
