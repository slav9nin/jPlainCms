package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;
import bit.cms.core.exception.UserIsNotAdminException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 9:41
 */
public class CoreFilter implements Filter {
    private static final long serialVersionUID = -6139556531717830440L;

    private Filter target;

    public CoreFilter() {
        this(new EmptyFilter());
    }

    public CoreFilter(Filter target) {
        this.target = target;
    }

    @Override
    public void execute(ServletRequest request, ServletResponse response)
            throws AuthenticationException, UserIsNotAdminException {
        if (target != null)
            target.execute(request, response);
    }
}
