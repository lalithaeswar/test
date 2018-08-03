package sampleproject.com.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {
    @SerializedName("name")
  private   String countryName;
    @SerializedName("code")
   private String countryCode;

    public CountryModel(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
