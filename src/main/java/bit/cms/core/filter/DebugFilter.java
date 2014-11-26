package bit.cms.core.filter;

import bit.cms.core.exception.AuthenticationException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Artem.Telizhenko
 *         Date: 12.11.2014
 *         Time: 8:49
 */
public class DebugFilter implements Filter {

    private Filter target;

    public DebugFilter() {
        this(null);
    }

    public DebugFilter(Filter target) {
        this.target = target;
    }

    @Override
    public void execute(ServletRequest request, ServletResponse response) throws AuthenticationException {
        if (target != null)
            target.execute(request, response);
    }
}
