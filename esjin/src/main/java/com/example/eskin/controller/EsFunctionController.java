package com.example.eskin.controller;

import com.example.eskin.po.SearchByEntity;

import com.example.eskin.vo.SearchByEntityVO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@RestController
public class EsFunctionController {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @RequestMapping(path = "/areyouok")
    public String Ok() throws IOException {
//
//
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(QueryBuilders.termQuery("user", "kimchy"));
//        sourceBuilder.from(0);
//        sourceBuilder.size(5);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("dingzhi");
//        searchRequest.types("test");
//        searchRequest.source(sourceBuilder);
//
//        restHighLevelClient.search(searchRequest);

        return "are you ok";
    }

    @RequestMapping(path = {"/SearchByEntity"},method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public SearchByEntityVO SearchByEntity(@RequestBody SearchByEntity searchByEntity) throws IOException {
        SearchByEntityVO searchByEntityVO = new SearchByEntityVO();
        searchByEntityVO.setSuccess(false);

        SearchSourceBuilder sourceBuilder;
        sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("age", 18));
        sourceBuilder.from(0);
        sourceBuilder.size(5);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        SearchRequest searchRequest = new SearchRequest();
        if(searchByEntity.getUrl().getIndex()!=null) {
            searchRequest.indices(searchByEntity.getUrl().getIndex());
        }
        searchRequest.types("test");
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest);

        StringBuilder stringBuilder = new StringBuilder();
        for(SearchHit searchHit:searchResponse.getHits().getHits()){
            stringBuilder.append(searchHit.getSourceAsString());
        }


        return searchByEntityVO;
    }

}