package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.exception.UserIsNotAdminException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by bito4ek on 08.12.14.
 */
public interface IFilterChain extends Serializable {
    public static final Filter DEFAULT_FILTER =
            new DebugFilter(new AuthenticationFilter(new CoreFilter()));

    public void processFilter(ServletRequest request, ServletResponse response)
            throws AuthenticationException, ServletException, IOException, UserIsNotAdminException;
}
