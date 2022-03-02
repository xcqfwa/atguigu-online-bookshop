package com.bear.book.pojo;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/2 16:02
 */
public class Page<T> {
    /**
     * 每页显示数量常量
     */
    public static final Integer PAGE_SIZE = 4;
    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 总页数
     */
    private Integer pageTotal;
    /**
     * 每页显示的数量
     */
    private Integer pageSize = PAGE_SIZE;
    /**
     * 总记录数
     */
    private Integer recordTotalCount;
    /**
     * 当前页数据
     */
    private List<T> items;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        // 数据边界性检查
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > this.pageTotal) {
            pageNo = this.pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordTotalCount() {
        return recordTotalCount;
    }

    public void setRecordTotalCount(Integer recordTotalCount) {
        this.recordTotalCount = recordTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", recordTotalCount=" + recordTotalCount +
                ", items=" + items +
                '}';
    }
}
