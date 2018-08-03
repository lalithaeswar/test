package sampleproject.com.retrofitexample.application;

import android.app.Application;
import android.content.Context;

import sampleproject.com.retrofitexample.config.Constant;
import sampleproject.com.retrofitexample.dependencies.component.AppComponent;
import sampleproject.com.retrofitexample.dependencies.component.DaggerAppComponent;
import sampleproject.com.retrofitexample.dependencies.module.ApplicationModule;
import sampleproject.com.retrofitexample.dependencies.module.NetworkModule;

public class AppController extends Application {
    private static AppComponent appComponent;
    private static AppController mInstance;

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();

    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}

