package sampleproject.com.retrofitexample.interfaces;

import android.util.Log;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sampleproject.com.retrofitexample.application.AppController;
import sampleproject.com.retrofitexample.model.JsonResp;
import sampleproject.com.retrofitexample.util.WebServiceUtils;


public class RequestCallback implements Callback<ResponseBody>{

    protected RequestListener listener;

    @Inject
    JsonResp jsonResp;
    @Inject
    WebServiceUtils webServiceUtils;

    public RequestCallback() {
        AppController.getAppComponent().inject(this);
    }

    public RequestCallback(RequestListener listener) {
        AppController.getAppComponent().inject(this);
        this.listener = listener;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            this.listener.onSuccess(getSuccessResponse(call, response));
        } catch (Exception e) {
            //LogManager.e(e.getMessage());
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        this.listener.onFailure(getFailureResponse(call, t));
    }

    private JsonResp getFailureResponse(Call<ResponseBody> call, Throwable t) {
        try {
            jsonResp.clearAll();
            if (call != null && call.request() != null) {
                jsonResp.setMethod(call.request().method());
                jsonResp.setRequestCode(webServiceUtils.getRequestCodeFromUrl(call.request().url().toString(), call.request().method()));
                jsonResp.setStrRequest(call.request().toString());
                jsonResp.setUrl(call.request().url().toString());
                //  LogManager.d(call.request().toString());
            }
            jsonResp.setIsSuccess(false);
            jsonResp.setErrorMsg(t.getMessage());
            // LogManager.e(t.getMessage());
        } catch (Exception e) {
            //LogManager.e(e.getMessage());
        }
        return jsonResp;
    }

    private JsonResp getSuccessResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            jsonResp.clearAll();
            if (call != null && call.request() != null) {
                jsonResp.setMethod(call.request().method());
                jsonResp.setRequestCode(webServiceUtils.getRequestCodeFromUrl(call.request().url().toString(), call.request().method()));
                jsonResp.setStrRequest(call.request().toString());
                jsonResp.setUrl(call.request().url().toString());
                // LogManager.d(call.request().toString());
            }
            if (response != null) {
                jsonResp.setResponseCode(response.code());
                //LogManager.i(String.valueOf(response.code()));
                if (response.isSuccessful()) {
                    String strJson = response.body().string();
                    jsonResp.setStrResponse(strJson);
                    //LogManager.i(strJson);
                    jsonResp.setIsSuccess(true);
                } else {
                    jsonResp.setIsSuccess(false);
                    jsonResp.setErrorMsg(response.errorBody().string());
                }
            }
        } catch (Exception e) {
            logManager(e.getMessage());
        }
        return jsonResp;
    }
    public void  logManager(String message)
    {
        Log.e("sample",message);
    }
}
