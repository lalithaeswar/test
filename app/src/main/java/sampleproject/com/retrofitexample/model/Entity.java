package sampleproject.com.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("countryDialCode")
    @Expose
    private String countryDialCode;
    @SerializedName("totalNumber")
    @Expose
    private String totalNumber;
    @SerializedName("multipleFormat")
    @Expose
    private Boolean multipleFormat;
    @SerializedName("phoneFormat")
    @Expose
    private String phoneFormat;

    private int mResId;

    public Entity(String name, String iso_code, int flag, String countryCode, String totalNumber, Boolean multipleFormat, String phoneFormat) {
        this.country = name;
        this.countryDialCode = iso_code;
        this.mResId = flag;
        this.countryCode = countryCode;
        this.totalNumber = totalNumber;
        this.multipleFormat = multipleFormat;
        this.phoneFormat = phoneFormat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryDialCode() {
        return countryDialCode;
    }

    public void setCountryDialCode(String countryDialCode) {
        this.countryDialCode = countryDialCode;
    }

    public String getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getmResId() {
        return mResId;
    }

    public void setmResId(int mResId) {
        this.mResId = mResId;
    }

    public Boolean getMultipleFormat() {
        return multipleFormat;
    }

    public void setMultipleFormat(Boolean multipleFormat) {
        this.multipleFormat = multipleFormat;
    }

    public String getPhoneFormat() {
        return phoneFormat;
    }

    public void setPhoneFormat(String phoneFormat) {
        this.phoneFormat = phoneFormat;
    }
}