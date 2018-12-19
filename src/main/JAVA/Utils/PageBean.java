package Utils;

import java.util.List;

public class PageBean<T> {
    private List<T> pageList;//分页后的记录信息
    private  int pagesize=4;//一页的记录条数,默认为4
    private int totalRows;//总记录条数
    private int totalPages;//总页数
    private int currentPage;//当前页
    private boolean firstPage; // 是否是第一页
    private boolean lastPage; // 是否是最后一页
    private int previousPageCount;// 上一页页码
    private int nextPageCount; // 下一页页码
    private int RowStart;//该页第一条记录,索引

    public int getRowStart() {
         RowStart=(currentPage-1)*pagesize;
        return RowStart;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalRows() {

        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        totalPages=totalRows % pagesize==0 ? totalRows / pagesize : totalRows / pagesize + 1;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        if(currentPage>totalPages)
        {
           this.currentPage=totalPages;
        }
        if (currentPage<1){
            this.currentPage=1;
        }
        previousPageCount=currentPage-1;
        nextPageCount=currentPage+1;
        if (currentPage==1){
            firstPage=true;
        }else {
            firstPage=false;
        }
        if (currentPage==totalPages){
            lastPage=true;
        }else{
            lastPage=false;
        }
    }

    public boolean isFirstPage() {
        return firstPage;
    }



    public boolean isLastPage() {
        return lastPage;
    }



    public int getPreviousPageCount() {
        return previousPageCount;
    }



    public int getNextPageCount() {
        return nextPageCount;
    }


}
