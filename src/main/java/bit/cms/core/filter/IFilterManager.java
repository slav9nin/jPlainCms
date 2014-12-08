package bit.cms.core.filter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by bito4ek on 08.12.14.
 */
public interface IFilterManager {
    public void processFilter(ServletRequest request,
                              ServletResponse response) throws ServletException, IOException;
}
