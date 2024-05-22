package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;

public class HomeViewModel extends ViewModel { //used for update UI

    private final NewsRepository repository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>();
    //countryInput livedata, 只要这个发生变化，下面那个LiveData<NewsResponse>也变化

    public HomeViewModel(NewsRepository newsRepository) {

        this.repository = newsRepository;
    }

    public void setCountryInput(String country) {

        countryInput.setValue(country);
    }

    public LiveData<NewsResponse> getTopHeadlines() {
        //ui call并且拿到newsresponse，只要是livedata就可以observe
        //countryinput
        return Transformations.switchMap(countryInput, repository::getTopHeadlines);
        //transform string data to newsponse
    }

    //用来被call favorite model
    public void setFavoriteArticleInput(Article article) {
        //no need to expose the observing result
        //direct call to the repository
        repository.favoriteArticle(article);
    }

}
