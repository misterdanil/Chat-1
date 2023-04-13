package com.example.lovelychecker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://192.168.0.11:8080";
    public static String JSESSION_ID;
    public static String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2NDM1Y2QwNDM1NzJjOTdlNzI0M2M1YzkiLCJleHAiOjMzNjI0OTQ5MDF9.4r6Bwx2_l2PavDxcWqIW9OsWVu1Bqf11Gu3xcQfHkZg";
    public static String ID = "6435cd043572c97e7243c5c9";
    public static interfaceAPI getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(interfaceAPI.class);
    }
}
