package com.sindorim.abilityocean.domain;


public class Page{
	
	private int totalCount;
    private int nowPage;
    private int listCount;
    private int groupCount;
    private int startPage;
    private int endPage;
    private int totalPage;
    private int firstRownum;
    private int secondRownum;

    public Page(int tc, int np){
        this(tc, np, 10, 10);
    }

    public Page(int tc, int np, int lc, int gc){
        totalCount = tc;
        nowPage = np;
        listCount = lc;
        groupCount = gc;
        totalPageCalc();
        startPageCalc();
        endPageCalc();
        rownumCalc(lc);
    }

    public void totalPageCalc(){
        totalPage = totalCount % listCount != 0 ? totalCount / listCount + 1 : totalCount / listCount;
    }

    public void startPageCalc(){
        startPage = nowPage - groupCount / 2;
        if(startPage < 1)
            startPage = 1;
    }

    public void endPageCalc(){
        endPage = (startPage + groupCount) - 1;
        if(endPage > totalPage)
            endPage = totalPage;
    }

    public void rownumCalc(int lc) {
        firstRownum = 0;
        secondRownum = 10;
        if(nowPage > 1)
        {
            firstRownum += lc * (nowPage - 1);
            secondRownum += lc * (nowPage - 1);
        }
    }

    public int getTotalCount(){
        return totalCount;
    }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }

    public int getNowPage()
    {
        return nowPage;
    }

    public void setNowPage(int nowPage)
    {
        this.nowPage = nowPage;
    }

    public int getListCount()
    {
        return listCount;
    }

    public void setListCount(int listCount)
    {
        this.listCount = listCount;
    }

    public int getGroupCount()
    {
        return groupCount;
    }

    public void setGroupCount(int groupCount)
    {
        this.groupCount = groupCount;
    }

    public int getStartPage()
    {
        return startPage;
    }

    public void setStartPage(int startPage)
    {
        this.startPage = startPage;
    }

    public int getEndPage()
    {
        return endPage;
    }

    public void setEndPage(int endPage)
    {
        this.endPage = endPage;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getFirstRownum()
    {
        return firstRownum;
    }

    public void setFirstRownum(int firstRownum)
    {
        this.firstRownum = firstRownum;
    }

    public int getSecondRownum()
    {
        return secondRownum;
    }

    public void setSecondRownum(int secondRownum)
    {
        this.secondRownum = secondRownum;
    }

}
