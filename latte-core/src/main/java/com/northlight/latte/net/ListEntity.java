package com.northlight.latte.net;

import android.support.annotation.Keep;

import java.util.List;

@Keep
public class ListEntity<T> {

    public int totalCount;
    public int pageSize;
    public int currPage;
    public boolean hasMore;
    public List<T> list;
    /**
     * 是否有跨账号支付
     */
    private boolean crossAccountPayment;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public boolean isCrossAccountPayment() {
        return crossAccountPayment;
    }

    public void setCrossAccountPayment(boolean crossAccountPayment) {
        this.crossAccountPayment = crossAccountPayment;
    }

}
