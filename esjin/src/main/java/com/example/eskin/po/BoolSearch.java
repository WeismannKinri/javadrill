package com.example.eskin.po;

import java.util.List;

public class BoolSearch {
    private List<QueryEntity> MustList;
    private List<QueryEntity> MustNotList;
    private List<QueryEntity> ShouldList;

    public List<QueryEntity> getMustList() {
        return MustList;
    }

    public void setMustList(List<QueryEntity> mustList) {
        MustList = mustList;
    }

    public List<QueryEntity> getMustNotList() {
        return MustNotList;
    }

    public void setMustNotList(List<QueryEntity> mustNotList) {
        MustNotList = mustNotList;
    }

    public List<QueryEntity> getShouldList() {
        return ShouldList;
    }

    public void setShouldList(List<QueryEntity> shouldList) {
        ShouldList = shouldList;
    }
}
