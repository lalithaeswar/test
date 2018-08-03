package sampleproject.com.retrofitexample.util;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

import javax.inject.Inject;

import sampleproject.com.retrofitexample.application.AppController;
import sampleproject.com.retrofitexample.config.Constant;

public class WebServiceUtils {
    @Inject
    Gson gson;

    public WebServiceUtils() {
        AppController.getAppComponent().inject(this);
    }

    public int getRequestCodeFromUrl(String requestUrl, String method) {
        Log.e(" Method ", method + " Url : " + requestUrl);
        int requestCode = 0;
        if (requestUrl.contains("?")) {
            requestUrl = requestUrl.substring(Constant.BASE_URL.length(), requestUrl.indexOf("?"));
        } else {
            requestUrl = requestUrl.substring(Constant.BASE_URL.length());
        }
        Log.e(" Method ", method + " Url : " + requestUrl);
        if (requestUrl.equals("login")) {
            requestCode = Constant.REQUEST_LOGIN;
        }


        return requestCode;
    }

    public Object getJsonObjectModel(String jsonString, Object object) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
            object = gson.fromJson(jsonObject.toString(), (Class<Object>) object);
        } catch (Exception e) {
            // LogManager.e(e.getMessage());
            return new Object();
        }
        return object;
    }

    public Object getJsonValue(String jsonString, String key, Object object) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
            if (jsonObject.has(key)) {
                object = jsonObject.get(key);
            }
        } catch (Exception e) {
            //LogManager.e(e.getMessage());
            return new Object();
        }
        return object;
    }

    public Object getJsonArrayModel(String jsonString, Object object) {
        JSONArray jsonArray = null;
        Object[] objects = null;
        try {
            jsonArray = new JSONArray(jsonString);
            if (jsonArray.length() > 0) {
                objects = gson.fromJson(jsonArray.toString(), (Class<Object[]>) object);
            }
        } catch (Exception e) {

            return new Object();
        }
        return new java.util.ArrayList(Arrays.asList(objects));
    }

    public Object getJsonObject(String jsonString, Object object) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
            object = gson.fromJson(jsonObject.toString(), (Class<Object>) object);
        } catch (Exception e) {

            return new Object();
        }
        return object;
    }
}
