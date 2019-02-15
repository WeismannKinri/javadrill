package com.example.eskin.po;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


public class SearchByEntity {
    private Url url;
    private Source source;
    private BoolSearch boolSearch;
    private FromSize fromSize;
    private List<Sort> sortList;

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public BoolSearch getBoolSearch() {
        return boolSearch;
    }

    public void setBoolSearch(BoolSearch boolSearch) {
        this.boolSearch = boolSearch;
    }

    public FromSize getFromSize() {
        return fromSize;
    }

    public void setFromSize(FromSize fromSize) {
        this.fromSize = fromSize;
    }

    public List<Sort> getSortList() {
        return sortList;
    }

    public void setSortList(List<Sort> sortList) {
        this.sortList = sortList;
    }
}
