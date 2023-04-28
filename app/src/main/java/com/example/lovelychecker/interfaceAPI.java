package com.example.lovelychecker;

import java.util.List;

import javax.xml.transform.Result;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Header;
import retrofit2.Call;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface interfaceAPI {

    @POST("/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("/signupf")
    Call<LoginResponse> signUp(@Body SignupRequest signupRequest);

    @POST("/accountVerification/{confirmToken}")
    Call<Post> confirm(@Path(value = "confirmToken") String confirmToken);

    @GET
    Call<LoginResponse> finishOAuth2(@Url String url, @Header("Cookie") String jsessionId);

    @GET("login/oauth2/{service}")
    Call<Void> oauth2(@Path(value="service") String service);

    @GET("/chat/{chatId}/messages")
    Call<List<Message>> getMessages(@Path(value = "chatId") String chatId);

    @Multipart
    @POST("/chat/{chatId}/message")
    Call<Void> sendMessage(@Path(value = "chatId") String chatId, @Part MultipartBody.Part text, @Part(value = "voice") RequestBody voice, @Header(value = "Authorization") String accessToken);

    @GET("/chats")
    Call<List<Chat>> getChats(@Header(value = "Authorization") String token);

    @GET("/product/smartphone/{id}")
    Call<Product> getProduct(@Path("id") String id);


    //@GET("/chats")
    //Call<Void> chatList(@Body )
}
