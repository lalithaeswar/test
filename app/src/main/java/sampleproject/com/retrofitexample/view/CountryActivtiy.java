package sampleproject.com.retrofitexample.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sampleproject.com.retrofitexample.R;
import sampleproject.com.retrofitexample.adapter.CountryAdapter;
import sampleproject.com.retrofitexample.interfaces.ApiService;
import sampleproject.com.retrofitexample.model.CountryList;
import sampleproject.com.retrofitexample.model.CountryModel;
import sampleproject.com.retrofitexample.model.Entity;
import sampleproject.com.retrofitexample.util.ApiClient;


public class CountryActivtiy extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Entity> countryList;
    private CountryList mCountryResponse;
    private final String TAG = "CountryActivity";
    Context contex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        contex = getApplicationContext();
        ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadRecycleData();


    }

    public void loadRecycleData() {
        //Creating an object of our api interface
        ApiService apiService =
                ApiClient.getClient().create(ApiService.class);

        // Calling JSON
        Call<CountryList> call = apiService.getCountries();

        call.enqueue(new Callback<CountryList>() {
            @Override
            public void onResponse(Call<CountryList> call, Response<CountryList> response) {
                if (response.body() != null) {
                    Toast.makeText(getApplicationContext(), "hi block", Toast.LENGTH_LONG).show();
                    try {
                        mCountryResponse = response.body();
                        countryList = mCountryResponse.getEntity();
                        showLog("Response==" + mCountryResponse.getStatus().getMsg());

                        for (int i = 0; i < countryList.size(); i++) {
                            showLog("CountryName==" + countryList.get(i).getCountry());
                        }


                            CountryAdapter countryAdapter = new CountryAdapter(countryList);
                            recyclerView.setAdapter(countryAdapter);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "catch block", Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<CountryList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showLog(String pMessage) {
        Log.e(TAG, pMessage);
    }


}



