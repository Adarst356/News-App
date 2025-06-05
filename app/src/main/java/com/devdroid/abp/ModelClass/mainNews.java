package com.devdroid.abp.ModelClass;

import java.util.ArrayList;

public class mainNews {
    private String status;
    private String totalResult;
    private ArrayList<NewsClass>articles;

    public mainNews(ArrayList<NewsClass> articles, String status, String totalResult) {
        this.articles = articles;
        this.status = status;
        this.totalResult = totalResult;
    }

    public ArrayList<NewsClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsClass> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }
}
