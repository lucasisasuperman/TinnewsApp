package com.laioffer.tinnews.network;

//chrome
//传一个api，然后用info call然后serilize

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //拿到request，先读header，return结构，要不要cache等会放在header里面


    private static final String API_KEY = "b0fd556683324435b2344ca0d2e0467f";
    private static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit newInstance() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //使用的第三方库，json deserilize to java class
                //string放进去，出来java class
                //string翻译成newsresponse
                //不能直接加header，只能通过加interceptor来写header
                .client(okHttpClient)
                .build();
    }

    private static class HeaderInterceptor implements Interceptor {
        //没有interceptor，有了url会直接去http返回json
        //有了之后，会打断加header

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request request = original
                    .newBuilder()
                    .header("X-Api-Key", API_KEY)
                    .build();
            return chain.proceed(request);
        }
    }
}
