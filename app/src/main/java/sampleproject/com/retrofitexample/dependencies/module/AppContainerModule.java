package sampleproject.com.retrofitexample.dependencies.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sampleproject.com.retrofitexample.config.Constant;
import sampleproject.com.retrofitexample.config.SessionManager;
import sampleproject.com.retrofitexample.model.JsonResp;
import sampleproject.com.retrofitexample.util.NetworkUtils;
import sampleproject.com.retrofitexample.util.WebServiceUtils;

/**
 * Created by Manikandan.k on 3/9/2017.
 */

@Module(includes = ApplicationModule.class)
public class AppContainerModule {
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return application.getSharedPreferences("sample", Context.MODE_PRIVATE);
    }


    @Provides
    @Singleton
    Context providesContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    ArrayList<String> providesStringArrayList() {
        return new ArrayList<>();
    }

    @Provides
    @Singleton
    NetworkUtils providesNetworkUtils(Application application) {
        return new NetworkUtils(application);
    }



    @Provides
    @Singleton
    SessionManager providesSessionManager() {
        return new SessionManager();
    }


    @Provides
    @Singleton
    WebServiceUtils providesWebServiceUtils() {
        return new WebServiceUtils();
    }






    @Provides
    @Singleton
    JsonResp providesJsonResp() {
        return new JsonResp();
    }


}



