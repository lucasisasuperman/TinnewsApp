package com.laioffer.tinnews.model;
//后面deseriallize到一个object

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;
@Entity //变成table
public class Article implements Serializable {
    public String author;
    public String content;
    public String description;
    public String publishedAt;
    public String title;
    @NonNull
    @PrimaryKey //primarykey 不能重复不能为空
    public String url;
    public String urlToImage;

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(author, article.author) && Objects.equals(content, article.content) && Objects.equals(description, article.description) && Objects.equals(publishedAt, article.publishedAt) && Objects.equals(title, article.title) && Objects.equals(url, article.url) && Objects.equals(urlToImage, article.urlToImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, content, description, publishedAt, title, url, urlToImage);
    }
}
