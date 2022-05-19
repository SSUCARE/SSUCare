package com.ssu.takecare.Retrofit;

import com.ssu.takecare.Retrofit.GetReport.ResponseGetReport;
import com.ssu.takecare.Retrofit.Info.RequestInfo;
import com.ssu.takecare.Retrofit.Info.ResponseInfo;
import com.ssu.takecare.Retrofit.InfoCheck.ResponseInfoCheck;
import com.ssu.takecare.Retrofit.Login.RequestLogin;
import com.ssu.takecare.Retrofit.Login.ResponseLogin;
import com.ssu.takecare.Retrofit.Match.ResponseCare;
import com.ssu.takecare.Retrofit.Report.RequestReport;
import com.ssu.takecare.Retrofit.Report.ResponseReport;
import com.ssu.takecare.Retrofit.Signup.RequestSignup;
import com.ssu.takecare.Retrofit.Signup.ResponseSignup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {
    // 회원가입
    @Headers("Content-Type: application/json")
    @POST("users")
    Call<ResponseSignup> registerRequest(@Body RequestSignup body);

    // 로그인
    @Headers("Content-Type: application/json")
    @POST("users/login")
    Call<ResponseLogin> loginRequest(@Body RequestLogin body);

    // 회원정보 저장
    @Headers("Content-Type: application/json")
    @PUT("users")
    Call<ResponseInfo> infoRequest(@Body RequestInfo body);

    // 회원정보 조회
    @Headers("Content-Type: application/json")
    @GET("/users")
    Call<ResponseInfoCheck> infoCheckRequest();

    // report 생성
    @Headers("Content-Type: application/json")
    @POST("/report")
    Call<ResponseReport> reportRequest(@Body RequestReport body);

    // report 조회하기
    @Headers("Content-Type: application/json")
    @GET("/report/{userId}")
    Call<ResponseGetReport> getReportRequest(@Path("userId")int path, @Query("year")int year, @Query("month")int month, @Query("date")int date);

    @Headers("Content-Type: application/json")
    @GET("/care")
    Call<List<ResponseCare>> GetCaredbRequest();


    @Headers("Content-Type: application/json")
    @POST("/care/{userEmail}")
    Call<Void> careRequest(@Path("userEmail") String path);


    @Headers("Content-Type: application/json")
    @POST("/care/{userid}/accept")
    Call<Object> careAcceptRequest(@Path("userId") int path);

    @Headers("Content-Type: application/json")
    @DELETE("/{userid}")
    Call<Object> careDeleteRequest(@Path("userId") int path);
}
