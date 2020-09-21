package com.example.app2;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public String BASE_URL="http://gank.io/";
    @GET("api/data/福利/70/1")
    Observable<ProjectBean> getData();
}
