package bit.cms.core.pagging;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bito4ek on 23.11.14.
 */
public interface Pagination<Bean> extends Serializable {

    public void setList(List<Bean> list);

    public void setMaxResults(Integer maxValue);

    public Integer getCurrentPage();

    public List<Bean> nextPage();

    public List<Bean> previousPage();

    public boolean isEnableNextPage();

    public boolean isEnablePreviousPage();

    public List<Bean> toPage(Integer pageValue);

    public void setDefaultSizePerPage(Integer size);

}
