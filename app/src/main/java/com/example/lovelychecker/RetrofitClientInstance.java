package com.example.lovelychecker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://192.168.0.11:8080";
    public static String JSESSION_ID;
    public static String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2NDQ4MzM0ZTk0OWQyYTc5ZjJhNTc3NmIiLCJleHAiOjMzNjQ5MTk5OTN9.LBvxf0e3Yunw2xTYgUotXdG6EEFZFg0D-Ot9-JMpI2w";
    public static String ID = "6448334e949d2a79f2a5776b";
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
