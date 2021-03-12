package cn.edu.xmut.personnelmanage.base;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiangjx
 * @version v1.0
 * @since 2021/3/11 15:56
 */
public class Page<T> implements Serializable {
    protected static final ThreadLocal<Page> LOCAL_PAGE = new ThreadLocal();

    private Integer totalPage;

    private Integer totalCount;

    private Integer pageSize = 10;

    private Integer pageNo = 1;

    private List<T> dataList;

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page(String json) {
        try {
            JSONObject obj = JSONObject.parseObject(json);
            if (obj != null) {
                this.pageNo = obj.getIntValue("pageNo");
                this.pageSize = obj.getIntValue("pageSize");
            }
        } catch (Exception var3) {
        }

    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalPage = totalCount / this.pageSize;
        Integer plus = 0;
        if (totalCount % this.pageSize > 0) {
            plus = 1;
        }

        this.totalPage = this.totalPage + plus;
        this.totalCount = totalCount;
    }

    protected static void setLocalPage(Page page) {
        LOCAL_PAGE.set(page);
    }

    public static <T> Page<T> getLocalPage() {
        return (Page)LOCAL_PAGE.get();
    }

    public static void clearPage() {
        LOCAL_PAGE.remove();
    }

    public static <E> Page<E> startPage(int pageNo, int pageSize) {
        if (pageNo <= 0) {
            pageNo = 1;
        }

        Page<E> page = new Page(pageNo, pageSize);
        setLocalPage(page);
        return page;
    }

}
