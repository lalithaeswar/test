package sampleproject.com.retrofitexample.model;

/*
 * Created by Ganesh K on 11-Sep-17.
 */
public class JsonResp {
    private String url;
    private String method;
    private String strRequest;
    private String strResponse;
    private int responseCode;
    private int requestCode;
    private String errorMsg;
    private boolean isSuccess;
    private int changedPosition;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStrRequest() {
        return strRequest;
    }

    public void setStrRequest(String strRequest) {
        this.strRequest = strRequest;
    }

    public String getStrResponse() {
        return strResponse;
    }

    public void setStrResponse(String strResponse) {
        this.strResponse = strResponse;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public void setChangedPosition(int changedPosition) {
        this.changedPosition = changedPosition;
    }

    public int getChangedPosition() {
        return this.changedPosition;
    }

    public void clearAll() {
        this.url = "";
        this.method = "";
        this.errorMsg = "";
        this.strRequest = "";
        this.strResponse = "";
        this.requestCode = 0;
        this.responseCode = 0;
        this.isSuccess = false;
    }

}
