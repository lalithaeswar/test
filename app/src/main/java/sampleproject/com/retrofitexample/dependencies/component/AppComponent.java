package sampleproject.com.retrofitexample.dependencies.component;




import javax.inject.Singleton;

import dagger.Component;
import sampleproject.com.retrofitexample.adapter.CountryAdapter;
import sampleproject.com.retrofitexample.config.SessionManager;
import sampleproject.com.retrofitexample.dependencies.module.AppContainerModule;
import sampleproject.com.retrofitexample.dependencies.module.ApplicationModule;
import sampleproject.com.retrofitexample.dependencies.module.NetworkModule;
import sampleproject.com.retrofitexample.interfaces.RequestCallback;
import sampleproject.com.retrofitexample.model.CountryList;
import sampleproject.com.retrofitexample.model.Entity;
import sampleproject.com.retrofitexample.model.JsonResp;
import sampleproject.com.retrofitexample.model.JsonResponse;
import sampleproject.com.retrofitexample.model.Status;
import sampleproject.com.retrofitexample.util.ApiClient;
import sampleproject.com.retrofitexample.util.WebServiceUtils;
import sampleproject.com.retrofitexample.view.CountryActivtiy;
import sampleproject.com.retrofitexample.view.LoginActivity;
import sampleproject.com.retrofitexample.view.MainActivity;

/**
 * Created by Manikandan.k on 3/9/2017.
 */

@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class, AppContainerModule.class})
public interface AppComponent {
    /*ACTIVITY*/
//
//    void inject(LoginActivity loginActivity);
//    void inject(MainActivity mainActivity);
//    void inject(CountryActivtiy countryActivtiy);

    /*JAVA CLASS*/
    void inject(SessionManager sessionManager);


    //Api service request callback
    void inject(RequestCallback requestCallback);


    //WebServiceUtils
    void inject(WebServiceUtils webServiceUtils);

    /*ADAPTER*/
    void inject(CountryAdapter countryAdapter);

    /*FRAGMENTS*/

    /*MODEL*/
    void inject(Entity entity);
    void inject(CountryList countryList);
    void  inject(Status status);
    void inject(JsonResp jsonResp);
    void inject(JsonResponse jsonResponse);

    /*UTIL*/
    void inject(ApiClient apiClient);



}

