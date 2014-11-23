package bit.cms.core.pagging;

import bit.cms.core.Constants;

import java.util.List;

import static bit.cms.core.Constants.ITEMS_PER_PAGE;

/**
 * Created by bito4ek on 23.11.14.
 */
public class ClientPagination<Bean> implements Pagination<Bean> {
    private static final long serialVersionUID = -4465946041326296006L;

    private List<Bean> currentList;
    private Integer maxResult;
    private Integer currentPage;
    private int itemsPerPage = ITEMS_PER_PAGE;

    public ClientPagination(List<Bean> currentList) {
        this.currentList = currentList;
    }

    public ClientPagination(Integer maxResult) {
        this.maxResult = maxResult;
    }

    public ClientPagination(List<Bean> currentList, Integer maxResult) {
        this.currentList = currentList;
        this.maxResult = maxResult;
    }

    public ClientPagination() {
    }

    @Override
    public void setList(List<Bean> list) {
        this.currentList = list;
    }

    @Override
    public void setMaxResults(Integer maxValue) {
        this.maxResult = maxValue;
    }

    @Override
    public Integer getCurrentPage() {
        return this.currentPage;
    }

    @Override
    public List<Bean> nextPage() {
        ++currentPage;
        return null;
    }

    @Override
    public List<Bean> previousPage() {
        return null;
    }

    @Override
    public boolean isEnableNextPage() {
        int page = currentPage;
        return !(++page > maxResult);
    }

    @Override
    public boolean isEnablePreviousPage() {
        int page = currentPage;
        return !(++page < maxResult);
    }

    @Override
    public List<Bean> toPage(Integer pageValue) {
        int page = currentPage;
        return null;
    }

    @Override
    public void setDefaultSizePerPage(Integer size) {
        this.itemsPerPage = size;
    }
}
