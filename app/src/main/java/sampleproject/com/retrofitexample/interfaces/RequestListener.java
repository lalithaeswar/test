package sampleproject.com.retrofitexample.interfaces;


import sampleproject.com.retrofitexample.model.JsonResp;

public interface RequestListener {
    void onSuccess(JsonResp jsonResp);

    void onFailure(JsonResp jsonResp);
}
