package com.laioffer.tinnews.model;

import java.util.List;
import java.util.Objects;

//request之后拿到的response
public class NewsResponse {
    public Integer totalResults;
    public List<Article> articles;
    public String code;
    public String message;
    public String status;

    @Override
    public String toString() {
        return "NewsResponse{" +
                "totalResults=" + totalResults +
                ", articles=" + articles +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsResponse that = (NewsResponse) o;
        return Objects.equals(totalResults, that.totalResults) && Objects.equals(articles, that.articles) && Objects.equals(code, that.code) && Objects.equals(message, that.message) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalResults, articles, code, message, status);
    }
}
