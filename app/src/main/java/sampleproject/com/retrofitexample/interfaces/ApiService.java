package sampleproject.com.retrofitexample.interfaces;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sampleproject.com.retrofitexample.model.CountryList;
import sampleproject.com.retrofitexample.model.Entity;

public interface ApiService {
    @GET("allcountry")
    Call<CountryList> getCountries();
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(@FieldMap Map<String, String> parameters);
}
