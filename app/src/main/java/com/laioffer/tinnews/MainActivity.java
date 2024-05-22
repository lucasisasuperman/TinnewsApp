package com.laioffer.tinnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.network.NewsApi;
import com.laioffer.tinnews.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        //fragment manager相当于管理stack的manager
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        //nav_host fragment -> navController
        navController = navHostFragment.getNavController(); //fragment壳的controller，直接用来做control
        //navController.navigate可以navigate到不同的fragment
        //navController.navigate(R.id.
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);
//        NewsApi api = RetrofitClient.newInstance().create(NewsApi.class);
//        //通过news api来实现interface function
//        api.getTopHeadlines("US").enqueue(new Callback<NewsResponse>() {
//            //callback inline实现了一个interface function
//            //成功就onresponse失败就onfailure
//            @Override
//            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                if(response.isSuccessful()){
//                    Log.d("get new TopHeadLines", response.body().toString());
//                }
//                else{
//                    Log.d("get new TopHeadLines", response.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NewsResponse> call, Throwable t) {
//                Log.d("get new TopHeadLines", t.toString());
//            }
//        });
    }

   @Override
   public boolean onSupportNavigateUp() {

        return navController.navigateUp(); //navigateup回到上一页
    }
}
