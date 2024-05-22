package com.laioffer.tinnews.ui.save;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.repository.NewsRepository;

import java.util.List;

public class SaveViewModel extends ViewModel {

    private final NewsRepository repository;

    public SaveViewModel(NewsRepository repository) {
        //similar to HomeViewModel and SearchViewModel
        this.repository = repository;
    }

    public LiveData<List<Article>> getAllSavedArticles() {
        //从database里面拿saved article，因此没有input
        return repository.getAllSavedArticles();
        //getAllSavedArticles get all saved articles from the database
        //updates in the Article table will immediately trigger new updates
    }

    public void deleteSavedArticle(Article article) {
        //删除
        repository.deleteSavedArticle(article);
    }
}
